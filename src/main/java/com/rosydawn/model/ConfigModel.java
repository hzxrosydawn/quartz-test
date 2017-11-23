package com.rosydawn.model;

import java.util.Date;

/**
 * Created by Vincent on 2017-11-22.
 */
public class ConfigModel {
    private String configId;
    private String systemName;
    private String groupName;
    private String configName;
    private String configValue;
    private Date insertTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "ConfigModel{" +
                "configId='" + configId + '\'' +
                ", systemName='" + systemName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", configName='" + configName + '\'' +
                ", configValue='" + configValue + '\'' +
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
