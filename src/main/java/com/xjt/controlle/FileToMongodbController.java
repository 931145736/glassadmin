package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.xjt.utils.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

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
    public void downloadFile(String fileNames, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Query query = Query.query(Criteria.where("filename").is(fileNames));

        // 查询单个文件
        GridFSDBFile gfsfile = gridFsTemplate.findOne(query);
        if (gfsfile == null) {
            return;
        }


        String fileName = gfsfile.getFilename().replace(",", "");
        //处理中文文件名乱码
        if (request.getHeader("User-Agent").toUpperCase().contains("MSIE") ||
                request.getHeader("User-Agent").toUpperCase().contains("TRIDENT")
                || request.getHeader("User-Agent").toUpperCase().contains("EDGE")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            //非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        // 通知浏览器进行文件下载
        response.setContentType(gfsfile.getContentType());
        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
        gfsfile.writeTo(response.getOutputStream());

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
