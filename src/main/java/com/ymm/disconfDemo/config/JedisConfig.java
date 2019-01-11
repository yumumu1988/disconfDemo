package com.ymm.disconfDemo.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
@DisconfFile(filename = "redis.properties")
@DisconfUpdateService(classes = {JedisConfig.class})
public class JedisConfig implements IDisconfUpdate {
    private String host;
    private int port;

    public JedisConfig() {
        this.host = "host";
        this.port = 1234;
    }

    @DisconfFileItem(name = "redis.host", associateField = "host")
    public String getHost() {
        System.out.println("getHost: " + host);
        return host;
    }

    public void setHost(String host) {
        this.host = host;
        System.out.println("setHost: " + this.host);
    }

    @DisconfFileItem(name = "redis.port", associateField = "port")
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String diyGetHost() {
        System.out.println("diyGetHost: " + this.host);
        return this.host;
    }

    public void reload() throws Exception {
        System.out.println("JedisConfig Changed->HOST: " + getHost() + "PORT: " + getPort());
    }
}
