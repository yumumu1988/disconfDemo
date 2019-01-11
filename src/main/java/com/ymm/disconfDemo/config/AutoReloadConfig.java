package com.ymm.disconfDemo.config;

public class AutoReloadConfig {
    private String name;
    private int age;

    public AutoReloadConfig() {
    }

    public String getName() {
        System.out.println("AutoReloadConfig.getName: " + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("AutoReloadConfig.setName: " + name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
