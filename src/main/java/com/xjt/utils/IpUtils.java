package com.xjt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassNameIpUtils
 * @Description
 * @Author
 * @Date2019/11/21 9:42
 * @Version V1.0
 **/
public class IpUtils {
    /**
     * 默认IP地址
     */
    public final static String ERROR_IP = "127.0.0.1";

    /**
     * IP地址正则表达式
     */
    public final static Pattern pattern = Pattern.compile(
            "(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})");



    /**
     *
     * @author HuaZai
     * @contact who.seek.me@java98k.vip
     * @title getUserIP
     *        <ul>
     * @description 获取用户真实的IP地址
     *              </ul>
     * @createdTime 2017年12月30日 下午6:42:17
     * @param request
     * @return String
     *
     * @version : V1.0.0
     */
    public static String getUserIP(HttpServletRequest request)
    {
        // 优先取 X-Real-IP
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("x-forwarded-for");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
            if ("0:0:0:0:0:0:0:1".equals(ip))
            {
                ip = ERROR_IP;
            }
        }
        if ("unknown".equalsIgnoreCase(ip))
        {
            ip = ERROR_IP;
            return ip;
        }
        int index = ip.indexOf(',');
        if (index >= 0)
        {
            ip = ip.substring(0, index);
        }

        return ip;
    }
    /**
     *
     * @author HuaZai
     * @contact who.seek.me@java98k.vip
     * @title getServerIP
     *        <ul>
     * @description 获取服务器IP地址
     *              </ul>
     * @createdTime 2017年12月30日 下午7:44:16
     * @return String
     *
     * @version : V1.0.0
     */
    public static String getServerIP()
    {
        InetAddress inetAddress;
        try
        {
            inetAddress = InetAddress.getLocalHost();
            String hostAddress = inetAddress.getHostAddress();
            return hostAddress;
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        return ERROR_IP;
    }
    /**
     *
     * @author HuaZai
     * @contact who.seek.me@java98k.vip
     * @title getRemoteIp
     *        <ul>
     * @description 获取远程IP地址
     *              </ul>
     * @createdTime 2017年12月30日 下午6:39:22
     * @param request
     * @return String
     *
     * @version : V1.0.0
     */
    public static String getRemoteIp(HttpServletRequest request)
    {
        String ip = request.getHeader("x-real-ip");
        if (ip == null)
        {
            ip = request.getRemoteAddr();
        }
        // 过滤反向代理的IP
        String[] stemps = ip.split(",");
        if (stemps != null && stemps.length >= 1)
        {
            // 得到第一个IP，即客户端真实IP
            ip = stemps[0];
        }

        ip = ip.trim();
        if (ip.length() > 23)
        {
            ip = ip.substring(0, 23);
        }

        return ip;
    }
    /**
     *
     * @author HuaZai
     * @contact who.seek.me@java98k.vip
     * @title getLastIpSegment
     *        <ul>
     * @description 获取末尾IP地址段，
     *              </ul>
     * @createdTime 2017年12月30日 下午6:44:09
     * @param request
     * @return String
     *
     * @version : V1.0.0
     */
    public static String getLastIpSegment(HttpServletRequest request)
    {
        // 获取用户真实的IP地址
        String ip = getUserIP(request);
        if (ip != null)
        {
            ip = ip.substring(ip.lastIndexOf('.') + 1);
        } else
        {
            ip = "0";
        }
        return ip;
    }
    /**
     *
     * @author HuaZai
     * @contact who.seek.me@java98k.vip
     * @title isValidIP
     *        <ul>
     * @description 验证IP地址是否符合规则
     *              </ul>
     * @createdTime 2017年12月30日 下午6:49:21
     * @param ip
     * @return boolean
     *
     * @version : V1.0.0
     */
    public static boolean isValidIP(String ip)
    {
        if (StringUtils.isEmpty(ip))
        {
            return false;
        }
        Matcher matcher = pattern.matcher(ip);
        boolean isValid = matcher.matches();
        return isValid;
    }

    private static Logger logger = LoggerFactory.getLogger(IpUtils.class);
    /**
     * 获取外网IP
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        // ipAddress = this.getRequest().getRemoteAddr();
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0
                || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0
                || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0
                || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            logger.info("ip"+ipAddress);


            if (ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
            // = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }


}
