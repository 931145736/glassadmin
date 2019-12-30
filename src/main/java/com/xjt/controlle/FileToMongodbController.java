package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.google.api.client.util.IOUtils;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.xjt.utils.FastDFSClientWrapper;
import jdk.nashorn.internal.runtime.UserAccessorProperty;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @ClassNameFileToMongodbController
 * @Description
 * @Author
 * @Date2019/12/2 8:59
 * @Version V1.0
 **/
@RestController
public class FileToMongodbController {


    // 获得SpringBoot提供的mongodb的GridFS对象
    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;
    private static final String[] FILE_TYPES =
            new String[] {
                    "jpg", "bmp", "jpeg", "png", "gif", "tif", "pcx", "tga", "exif", "exif", "svg",
                    "psd", "cdr", "pcd", "dxf", "ufo", "eps", "ai", "raw", "WMF", "webp"
            };


    @RequestMapping("/uploadFileToFASTDfs")
    public String uploadFileToFASTDfs(@RequestParam("file") MultipartFile file) throws IOException {
        String path = fastDFSClientWrapper.uploadFile(file);

        return path;
    }


    @RequestMapping("/uploadFileToMongo")
    public Object uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        InputStream is = file.getInputStream();
        String contentType = file.getContentType();
        GridFSFile gridFSFile = gridFsTemplate.store(is,fileName,contentType);

        return JSONObject.toJSONString(gridFSFile);
    }

    @RequestMapping("/downloadFile")
    @ResponseBody
    public void downloadFile(@RequestParam("md5") String md5, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Query query = Query.query(Criteria.where("md5").is(md5));
        GridFSDBFile file = gridFsTemplate.findOne(query);
        if (null == file) {
            throw new RuntimeException("ID对应文件不存在");
        }



    }

    @RequestMapping("/deleteFile")
    public String deleteFile(String fileName){
        Query query = Query.query(Criteria.where("filename").is(fileName));
        // 查询单个文件
        GridFSDBFile gfsfile = gridFsTemplate.findOne(query);
        if (gfsfile == null) {
            return "no file";
        }else{
            gridFsTemplate.delete(query);
            return "ok";
        }


    }
}
