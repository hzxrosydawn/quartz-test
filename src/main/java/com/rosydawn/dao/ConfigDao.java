package com.rosydawn.dao;

import com.rosydawn.model.ConfigModel;

/**
 * Created by Vincent on 2017-11-22.
 */
public interface ConfigDao {
//    ConfigModel selectConfigModel(String systemName, String groupName, String configName);
    ConfigModel selectConfigModel(String configId);
//    List<ConfigModel> selectConfigList(String systemName);
}
