package com.rosydawn.service.impl;

import com.rosydawn.service.JobService;
import com.rosydawn.service.SchedulerService;
import org.apache.log4j.Logger;
import org.quartz.TriggerKey;

/**
 * Created by Vincent on 2017-11-23.
 */
public class JobServiceImpl implements JobService {
    private static final Logger logger = Logger.getLogger(JobServiceImpl.class);

    private SchedulerService schedulerService;

    @Override
    public void executeJob01() {
        logger.info("执行任务Job01 开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TriggerKey triggerKey = new TriggerKey("triggerName01", "triggerGroupName01");

        schedulerService.updateTrigger(triggerKey);
        logger.info("执行任务Job01 结束");
    }

    public SchedulerService getSchedulerService() {
        return schedulerService;
    }

    public void setSchedulerService(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }
}
