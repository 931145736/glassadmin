package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.xjt.annotation.SecurityParameter;
import com.xjt.annotation.UserLog;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.MasterReqDto;
import com.xjt.entity.Master;
import com.xjt.entity.ResponseEntity;
import com.xjt.enums.ResultCode;
import com.xjt.service.MasterService;
import com.xjt.utils.PrimaryKeyWorker;
import com.xjt.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserLoginController {

    @Autowired
    private MasterService masterService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private PrimaryKeyWorker primaryKeyWorker;
    private   Map<String,Object> map;



    @Value("${login.validity.time}")
    private Long loginValidityTime;
    @Value("${project.saveFilePath}")
    private String saveFilePath;

    private Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @RequestMapping("/encode")
    @SecurityParameter(inDecode = false)
    @ResponseBody
    public Map<String,Object>  encode(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","admin");
        map.put("password",1234);
        return map;
    }


    @UserLog("用户登录")
    @SecurityParameter(outEncode = false)
    @RequestMapping("/userLogin")
    @ResponseBody
    public ResponseEntity userLogin ( @RequestBody MasterReqDto reqDto,HttpServletRequest request){
         ResponseEntity entity = new ResponseEntity();
         logger.info("前端数据"+JSONObject.toJSONString(reqDto));
        BaseResDto baseResDto = masterService.userLoginResolve(reqDto);
        //第一次登陆成功 生成token 返回用户id和token
        if(baseResDto.getResultCode()==1){
            //登录成功，返回动态密钥 同时把密钥，用户信息存入map集合，把map存入session
            Master master = (Master) baseResDto.getData();
            String userId = master.getId();
            String token = UUID.randomUUID().toString();
            redisUtil.set(token,master,loginValidityTime);
            request.setAttribute("currentUser",master);

                entity.setToken(token);
                entity.setUserId(userId);
                entity.setReturnType("1001");
                entity.setMessage("登录成功");
                logger.info("登录成功");
        }else{
            entity.setReturnType("1002");
            entity.setMessage(baseResDto.getResultMessage());
        }

        return entity;
    }

    @UserLog("退出登录")
    @RequestMapping("/quiteLogin")
    @ResponseBody
    public BaseResDto quiteLogin(HttpServletRequest request,HttpSession session){
        BaseResDto baseResDto = new BaseResDto();
        String token = request.getHeader("token");
     /*   map = (Map<String, Object>) session.getAttribute("objMap");
        if(map!=null){
            map.remove(token);
        }*/

        redisUtil.del(token);

        logger.info("退出成功");
        return baseResDto;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }



    @RequestMapping("/fileDownload")
    @ResponseBody
    public void  fileDownload(@RequestParam("filePath") String filePath, HttpServletResponse response) throws IOException {
        // 文件地址，真实环境是存放在数据库中的
        int index = filePath.lastIndexOf(".");
        String fileName = filePath.substring(index);
        File file = new File(filePath);
        // 穿件输入对象
        FileInputStream fis = new FileInputStream(file);
        // 设置相关格式
        response.setContentType("application/force-download");
        // 设置下载后的文件名以及header
        response.addHeader("Content-disposition", "attachment;fileName=" + fileName);
        // 创建输出对象
        OutputStream os = response.getOutputStream();
        // 常规操作
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        fis.close();


    }


    @RequestMapping("/testAop")
    @ResponseBody
    public String testAop(HttpSession session){
       return  session.getAttribute("userId").toString();
    }
}
