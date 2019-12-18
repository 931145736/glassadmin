package com.xjt.utils;



import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;

import com.github.tobato.fastdfs.service.FastFileStorageClient;

import com.xjt.config.FastDFSConfig;
import org.apache.commons.io.FilenameUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * <p>Description: FastDFS文件上传下载包装类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 *
 * @author songfeiyue
 * @version 1.0
 * @date 2018/12/26
 */
@Component
public class FastDFSClientWrapper {

    private final Logger logger = LoggerFactory.getLogger(FastDFSClientWrapper.class);

    @Resource
    private FastFileStorageClient storageClient;

    @Autowired
    private FastDFSConfig fastDFSConfig;   // 项目参数配置

    /**
     * base64转MultipartFile
     */
    public static MultipartFile base64ToMultipart(String base64) {
        try {
            String[] baseStrs = base64.split(",");

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = new byte[0];
            b = decoder.decodeBuffer(baseStrs[1]);

            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }

            return new BASE64DecodeMultipartFile(b, baseStrs[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 批量上传文件
     *
     * @param multipartFiles 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public Map<String,String> uploadFileBatch(List<MultipartFile> multipartFiles) {
        Map<String,String> pathMap = new HashMap<>();
        try {
            for (int index = 0, iLen = multipartFiles.size(); index < iLen; index++) {
                MultipartFile multipartFile = multipartFiles.get(index);
                String sourceFileName = multipartFile.getOriginalFilename();
                StorePath storePath = storageClient.uploadFile(multipartFile.getInputStream(), multipartFile.getSize(), FilenameUtils.getExtension(multipartFile.getOriginalFilename()), null);
                pathMap.put(sourceFileName,getResAccessUrl(storePath));
            }
        }catch (Exception e){
            logger.error("批量上传文件异常",e);
            if(pathMap.size() > 0){
                for(Map.Entry<String,String> entry : pathMap.entrySet()){
                   // deleteFile(entry.getValue());
                }
            }
            pathMap = null;
        }
        return pathMap;
    }

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        logger.info("file:"+file.getOriginalFilename());
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return getResAccessUrl(storePath);
    }

    /**
     * 上传png图片
     *
     * @param inputStream 文件流
     * @return
     * @throws IOException
     */
    public String uploadPngFile(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[inputStream.available()];
        StorePath storePath = storageClient.uploadFile(inputStream, bytes.length, "png", null);
        return getResAccessUrl(storePath);
    }

    /**
     * 上传文件
     *
     * @param inputStream 文件流
     * @return
     * @throws IOException
     */
    public String uploadFile(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[inputStream.available()];
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        StorePath storePath = storageClient.uploadFile(stream, bytes.length, "jpg", null);
        return getResAccessUrl(storePath);
    }

    /**
     * 将一段字符串生成一个文件上传
     *
     * @param content       文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream, buff.length, fileExtension, null);
        return getResAccessUrl(storePath);
    }

    /**
     * 封装图片完整URL地址
     *
     * @param storePath
     * @return
     */
    private String getResAccessUrl(StorePath storePath) {
        String fileUrl = "http://" + fastDFSConfig.getReqHost()
                + ":" + fastDFSConfig.getFdfsStoragePort()+ "/" + storePath.getFullPath();
        return fileUrl;
    }

    /**
     * 删除文件
     *
     * @param fileUrl 文件访问地址
     * @return
     */
  /*  public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            logger.warn(e.getMessage());
        }
    }*/

    /**
     * 下载文件
     */
 /*   public String downFile(String filePath) {
        byte[] bytes;
        StorePath storePath = StorePath.praseFromUrl(filePath);
        bytes = storageClient.downloadFile(storePath.getGroup(), storePath.getPath(), new DownloadByteArray());
        String content = new String(bytes, StandardCharsets.UTF_8);
        return content;
    }*/

}
