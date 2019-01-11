package com.ymm.disconfDemo;

import com.ymm.disconfDemo.service.DisconfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DisconfDemoMain {
    protected static final Logger LOGGER = LoggerFactory.getLogger(DisconfDemoMain.class);
    public static void main(String[] args) {
        String[] fn = new String[]{"applicationContext.xml"};
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(fn);
        DisconfService disconfService = ctx.getBean("disconfService", DisconfService.class);
        LOGGER.info("start");
        disconfService.run();
    }

}
