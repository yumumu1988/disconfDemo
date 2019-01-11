package com.ymm.disconfDemo.config;

public class AutoConfig {
    private String ip;
    private int port;

    public AutoConfig() {
    }

    public String getIp() {
        System.out.println("AutoConfig.getIp: " + ip);
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
        System.out.println("AutoConfig.setIp: " + ip);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
