package com.rosydawn.mapper;

import com.rosydawn.model.ConfigModel;

/**
 * Created by Vincent on 2017-11-22.
 */
public interface ConfigMapper {
    ConfigModel selectConfigModel(String systemName, String itemName);
    ConfigModel selectConifgModel(String configId);
}
