package com.xjt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Description: tagservice
 * Created by Administrator on 2018/12/26 12:16
 *
 * @author Administrator
 */
@Component
public class PrimaryKeyWorker {

    @Autowired
    private RedisUtil redisUtil;



    Logger logger = LoggerFactory.getLogger(PrimaryKeyWorker.class);

    private String getOrderIDPrefix(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHH");
        String formatTime = simpleDateFormat.format(date);
        return formatTime;
    }

    public String getPrimaryKey(String prefix) {
        StringBuffer key = new StringBuffer(prefix);
        String dateStr = getOrderIDPrefix(new Date());
        key.append(dateStr);
        String primaryKey = null;
        try {
            String uuid = STRUtils.createUUID().substring(0,3);
            Long index = redisUtil.incr(key.toString(),1L);
            if (index == 1) {
                redisUtil.expire(key.toString(),3600);
            }
            StringBuffer stringBuffer = new StringBuffer(prefix);
            stringBuffer.append(dateStr).append(uuid).append(String.format("%07d", index));
            primaryKey =stringBuffer.toString();
        } catch (Exception e) {
            logger.error("generate primary key error",e);
            primaryKey = getPrimaryKey(prefix);//重试一次
        }
        return primaryKey;
    }

}
