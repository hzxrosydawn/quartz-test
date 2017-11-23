package com.rosydawn.service.impl;

import com.rosydawn.dao.ConfigDao;
import com.rosydawn.dao.SchedulerDao;
import com.rosydawn.model.ConfigModel;
import com.rosydawn.service.SchedulerService;
import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.TriggerKey;

/**
 * Created by Vincent on 2017-11-21.
 */
public class SchedulerServiceImpl implements SchedulerService {
    private static final Logger logger = Logger.getLogger(SchedulerServiceImpl.class);

    private SchedulerDao schedulerDao;
    private ConfigDao configDao;

    @Override
    public void updateTrigger(TriggerKey triggerKey) {
        logger.info("update the trigger whose trigger key is " + triggerKey);
        CronTrigger cronTrigger = schedulerDao.selectCronTrigger(triggerKey);
        if (cronTrigger != null) {
            String description = cronTrigger.getDescription();
            ConfigModel configModel = configDao.selectConfigModel("");
            if (configModel != null) {
                String cronExpression = configModel.getConfigValue();
                schedulerDao.updateCronTrigger(triggerKey, cronExpression, description);
            }
        }
    }

    public SchedulerDao getSchedulerDao() {
        return schedulerDao;
    }

    public void setSchedulerDao(SchedulerDao schedulerDao) {
        this.schedulerDao = schedulerDao;
    }

    public ConfigDao getConfigDao() {
        return configDao;
    }

    public void setConfigDao(ConfigDao configDao) {
        this.configDao = configDao;
    }
}
