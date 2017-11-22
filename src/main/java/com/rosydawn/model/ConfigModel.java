package com.rosydawn.model;

import java.util.Date;

/**
 * Created by Vincent on 2017-11-22.
 */
public class ConfigModel {
    private String configId;
    private String systemName;
    private String itemName;
    private String itemValue;
    private Date insertTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "ConfigModel{" +
                "configId='" + configId + '\'' +
                ", systemName='" + systemName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemValue='" + itemValue + '\'' +
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
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
