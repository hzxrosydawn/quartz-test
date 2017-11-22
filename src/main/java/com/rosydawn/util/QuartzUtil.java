package com.rosydawn.util;

import org.quartz.*;

import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.CronScheduleBuilder.cronSchedule;

/**
 * Created by Vincent on 2017-11-22.
 */
public class QuartzUtil {

    /**
     * replace the cron trigger with a new cron trigger which has the the same trigger key
     *
     * @param scheduler
     * @param triggerKey
     * @param cronExpression
     * @param triggerDescription
     */
    public static void updateCronTrigger(Scheduler scheduler, TriggerKey triggerKey, String cronExpression,
                                         String triggerDescription) {
        try {
            CronTrigger newCronTrigger = newTrigger()
                    .withIdentity(triggerKey)
                    .withSchedule(cronSchedule(cronExpression))
                    .withDescription(triggerDescription)
                    .build();
            scheduler.rescheduleJob(triggerKey, newCronTrigger);
        } catch (Exception e) {
            throw new RuntimeException("failed to changeCronException", e);
        }
    }

    /**
     * replace the cron trigger with a new cron trigger which has the the same trigger name and trigger group name
     * @param scheduler
     * @param triggerName
     * @param triggerGroupName
     * @param cronExpression
     * @param triggerDescription
     */
    public static void updateCronTrigger(Scheduler scheduler, String triggerName, String triggerGroupName,
                                         String cronExpression, String triggerDescription) {
        TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroupName);
        updateCronTrigger(scheduler, triggerKey, cronExpression, triggerDescription);
    }

    public static void startScheduler(Scheduler scheduler) {
        try {
            //
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            throw new RuntimeException("failed to start the scheduler", e);
        }
    }
}
