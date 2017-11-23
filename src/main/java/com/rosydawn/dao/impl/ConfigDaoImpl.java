package com.rosydawn.dao.impl;

import com.rosydawn.dao.ConfigDao;
import com.rosydawn.model.ConfigModel;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Created by Vincent on 2017-11-23.
 */
public class ConfigDaoImpl extends HibernateDaoSupport implements ConfigDao {
    @Override
    public ConfigModel selectConfigModel(String configId) {

        return null;
    }
}
