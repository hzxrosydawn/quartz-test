package com.rosydawn.dao;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.TriggerKey;

/**
 * Created by Vincent on 2017-11-23.
 */
public interface SchedulerDao {
    void updateCronTrigger(TriggerKey triggerKey, String cronExpression, String triggerDescription);
    CronTrigger selectCronTrigger(TriggerKey triggerKey);
    void addJobDetail(JobDetail jobDetail, boolean replaceIfExist);
}
