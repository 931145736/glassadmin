package com.xjt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description: tagservice
 * Created by Administrator on 2018/12/26 16:11
 */
@Component
@ConfigurationProperties(prefix = "fdfs")
public class FastDFSConfig {

    private String HTTP_PRODOCOL;

    private String reqHost;

    private String fdfsStoragePort;


    public String getHTTP_PRODOCOL() {
        return HTTP_PRODOCOL;
    }

    public void setHTTP_PRODOCOL(String HTTP_PRODOCOL) {
        this.HTTP_PRODOCOL = HTTP_PRODOCOL;
    }

    public String getReqHost() {
        return reqHost;
    }

    public void setReqHost(String reqHost) {
        this.reqHost = reqHost;
    }

    public String getFdfsStoragePort() {
        return fdfsStoragePort;
    }

    public void setFdfsStoragePort(String fdfsStoragePort) {
        this.fdfsStoragePort = fdfsStoragePort;
    }
}
