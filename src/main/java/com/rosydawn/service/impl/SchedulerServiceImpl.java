package com.rosydawn.service.impl;

import com.rosydawn.service.SchedulerService;
import com.rosydawn.util.QuartzUtil;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by Vincent on 2017-11-22.
 */
public class SchedulerServiceImpl implements SchedulerService {
    private static final Logger logger = Logger.getLogger(SchedulerServiceImpl.class);

    private SchedulerFactoryBean schedulerFactoryBean;

    /**
     *
     * @param triggerKey
     * @param cronExpression
     * @param triggerDescription
     */
    public void updateCronTrigger(TriggerKey triggerKey, String cronExpression,
                                  String triggerDescription) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            CronTrigger newCronTrigger = newTrigger()
                    .withIdentity(triggerKey)
                    .withSchedule(cronSchedule(cronExpression))
                    .withDescription(triggerDescription)
                    .build();
            scheduler.rescheduleJob(triggerKey, newCronTrigger);
        } catch (Exception e) {
            logger.error("update CronTrigger error!", e);
            throw new RuntimeException("update CronTrigger error!", e);
        }
    }

    public void addJobDetail(JobDetail jobDetail, boolean replaceIfExist) {
        if (jobDetail.isDurable()) {
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
            try {
                scheduler.addJob(jobDetail, replaceIfExist);
            } catch (SchedulerException e) {
                logger.error("add a new JobDetail error!", e);
                throw new RuntimeException("add a new JobDetail error!", e);
            }
        } else {
            logger.error("the added JobDetail is not durable!");
            throw new RuntimeException("the added JobDetail is not durable!");
        }
    }


}
