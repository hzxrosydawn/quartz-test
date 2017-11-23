package com.rosydawn.dao.impl;

import com.rosydawn.dao.SchedulerDao;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by Vincent on 2017-11-23.
 */
public class SchedulerDaoImpl implements SchedulerDao {
    private static final Logger logger = Logger.getLogger(SchedulerDaoImpl.class);

    private SchedulerFactoryBean schedulerFactoryBean;

    /**
     * @param triggerKey
     * @param cronExpression
     * @param triggerDescription
     */
    @Override
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
            logger.info("update " + triggerKey + " cron trigger`s cron expression to " + cronExpression
                    + "successfully!");
        } catch (Exception e) {
            logger.error("update " + triggerKey + " cron trigger`s cron expression to " + cronExpression
                    + "failed!", e);
            throw new RuntimeException("update CronTrigger error!", e);
        }
    }

    @Override
    public CronTrigger selectCronTrigger(TriggerKey triggerKey) {
        CronTrigger cronTrigger = null;
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            logger.error("get CronTrigger error!", e);
            throw new RuntimeException("get CronTrigger error!", e);
        }
        return cronTrigger;
    }

    /**
     * The Job will be 'dormant' until it is scheduled with a Trigger or Scheduler.triggerJob() is called for it.
     * If replaceIfExist is set to true, the job will be added even if a Job with the same name already exists.
     * The added Job has to be durable, or it can`t be added to the scheduler.
     *
     * @param jobDetail
     * @param replaceIfExist
     */
    @Override
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
            logger.error("the added Job is not durable!");
            throw new RuntimeException("the added Job is not durable!");
        }
    }
}
