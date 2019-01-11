package com.ymm.disconfDemo.config;

import com.baidu.disconf.client.common.annotations.DisconfItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
@DisconfUpdateService(itemKeys = {"taskStatus", "databaseType"})
public class ItemConfig implements IDisconfUpdate {

    private static final String key1 = "taskStatus";
    private static final String key2 = "databaseType";

    @Value(value = "false")
    private boolean taskStatus;

    @Value(value = "mysql")
    private String dbType;

    @DisconfItem(key = key1)
    public boolean isTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    @DisconfItem(key = key2)
    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public void reload() throws Exception {
        System.out.println("ItemConfig Reload->taskStatus: " + this.taskStatus + "; databaseType: " + dbType);
    }
}
