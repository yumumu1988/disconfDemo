package com.ymm.disconfDemo.service;

import com.baidu.disconf.client.common.annotations.DisconfItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.ymm.disconfDemo.config.AutoConfig;
import com.ymm.disconfDemo.config.AutoReloadConfig;
import com.ymm.disconfDemo.config.ItemConfig;
import com.ymm.disconfDemo.config.JedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
@DisconfUpdateService(itemKeys = {"callbackEnable"})
public class DisconfService implements IDisconfUpdate {

    @Autowired
    private JedisConfig jedisConfig;

    @Autowired
    private AutoConfig autoConfig;

    @Autowired
    private AutoReloadConfig autoReloadConfig;

    @Autowired
    private ItemConfig itemConfig;

    private static final String key = "callbackEnable";

    private String callbackEnable;

    @DisconfItem(key = key)
    public String getCallbackEnable() {
        return callbackEnable;
    }

    public void setCallbackEnable(String callbackEnable) {
        this.callbackEnable = callbackEnable;
        System.out.println("setCallbackEnable: " + callbackEnable);
    }

    public void run() {
        try {

            while (true) {
                System.out.println("---JedisConfig---");
                // AOP方式拦截get方法
                System.out.println("HOST: " + jedisConfig.getHost());
                System.out.println("PORT: " + jedisConfig.getPort());
                System.out.println("DIY HOST: " + jedisConfig.diyGetHost());
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");
                // 直接调用get方法
                System.out.println("ip: " + autoConfig.getIp());
                System.out.println("port: " + autoConfig.getPort());
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
                // 直接调用get方法
                System.out.println("name: " + autoReloadConfig.getName());
                System.out.println("age: " + autoReloadConfig.getAge());
                System.out.println("==========================");
                // 配置类配置项
                System.out.println("taskStatus: " + itemConfig.isTaskStatus());
                System.out.println("databaseType: " + itemConfig.getDbType());
                System.out.println("--------------------------");
                // Service配置项
                System.out.println("callbackEnable1: " + callbackEnable);
                System.out.println("callbackEnable2: " + getCallbackEnable());
                Thread.sleep(5000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reload() throws Exception {
        System.out.println("callbackEnable changed: " + this.callbackEnable);
    }
}
