package com.xjt.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * describe:
 *
 * @author dengzl
 * @date 2019/06/10
 */

public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);



    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response) throws RuntimeException {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, pojoClass, fileName, response, exportParams);
    }
    public static void exportExcel(List<?> list, Class<?> pojoClass, String fileName,  HttpServletResponse response) throws RuntimeException {
        ExportParams exportParams = new ExportParams();
        defaultExport(list, pojoClass, fileName, response, exportParams);
    }
    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass,String fileName, HttpServletResponse response) throws RuntimeException {
        defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName));
    }
    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) throws RuntimeException {
        defaultExport(list, fileName, response);
    }

    private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) throws RuntimeException {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,pojoClass,list);
        if (workbook != null);
        downLoadExcel(fileName, response, workbook);
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) throws RuntimeException {
        OutputStream outputStream=null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            outputStream = response.getOutputStream();

            workbook.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) throws RuntimeException {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null);
        downLoadExcel(fileName, response, workbook);
    }

    public static <T> List<T> importExcel(String filePath,Integer titleRows,Integer headerRows, Class<T> pojoClass) throws RuntimeException {
        if (StringUtils.isBlank(filePath)){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        }catch (NoSuchElementException e){
            throw new RuntimeException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }
    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) throws RuntimeException {
        if (file == null){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        }catch (NoSuchElementException e){
            throw new RuntimeException("excel文件不能为空");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

    /**
     * 实现单文件上传
     */
    public static  boolean uploadFile(MultipartFile file,String saveFilePath){
        boolean flag = true;
        if(file.isEmpty()){
           flag = false;
           return flag;
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        File dest = new File(saveFilePath + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
          flag = true;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            flag = false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
           flag = false;
        }
        return flag;
    }

    /**
     * 批量上传图片
     * @param files
     * @param savePath
     * @return
     */
    public static int  uploadFileBatch(List<MultipartFile> files,String savePath){
        if(files.isEmpty()){
            return 0;
        }
        int i = 0;
        for(MultipartFile file:files){
            boolean flag = uploadFile(file,savePath);
            if(flag){
                i++;
            }else{

            }
        }
        return i;
    }

    /**
     * 删除文件
     * @param filePath
     * @return
     */
    public static boolean deleteFile(String filePath){
        boolean flag = false;
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                flag = true;
            }
        }
        return flag;

    }
    
    /**
    *@Description 上传excel模板
    * * @param null
    *@Return 
    *@Author Administrator
    *@Date 2019/11/25
    *@Time 
    */

    public static void insertExcelTemplates(List<MultipartFile> files,String path){
        if(files!=null&&files.size()>0){

            // 创建数组型缓冲等待队列
            BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(10);
            // ThreadPoolExecutor:创建自定义线程池
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 6, 50, TimeUnit.MILLISECONDS, bq);

            for (MultipartFile multipartFile : files) {
                //执行线程
                threadPoolExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        String fileName = multipartFile.getOriginalFilename();
                        logger.info("文件名"+fileName);

                        try {
                            String path =System.getProperty("user.dir");
                            logger.info("绝对路径"+path);
                            String savePath = path+"/src/main/resources/excel/"+UUID.randomUUID()+fileName;
                            logger.info("保存路径"+savePath);
                            // 文件对象
                            File dest = new File(savePath);
                            // 判断路径是否存在，如果不存在则创建
                            if(!dest.getParentFile().exists()) {
                                dest.getParentFile().mkdirs();
                            }
                            // 保存到服务器中
                            multipartFile.transferTo(dest);



                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

        }
    }
    /***
     *@Description 下载excel模板
     * * @param filePath
     * @param response
     *@Return void
     *@Author Administrator
     *@Date 2019/11/22
     *@Time
     */

    public static void  exportExcelTemplate(String filePath,HttpServletResponse response) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(filePath);

        InputStream inputStream =classPathResource.getInputStream();
        String fileName = filePath.substring(filePath.indexOf("/")+1);
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        // response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(fileName,"UTF-8"));
        byte[] buffer = new byte[1024];
        //  FileInputStream fis = null; //文件输入流
        BufferedInputStream bis = null;

        OutputStream os = null; //输出流
        try {
            os = response.getOutputStream();
            // fis = new FileInputStream(file);
            bis = new BufferedInputStream(inputStream);
            int i = bis.read(buffer);
            while(i != -1){
                os.write(buffer);
                i = bis.read(buffer);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            bis.close();
            //  fis.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

