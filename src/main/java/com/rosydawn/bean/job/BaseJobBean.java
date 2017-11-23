package com.rosydawn.bean.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.Serializable;

/**
 * Created by Vincent on 2017-11-23.
 */
abstract class BaseJobBean extends QuartzJobBean  implements Serializable {
    private static final Logger logger = Logger.getLogger(BaseJobBean.class);

    ApplicationContext getApplicationContext(final JobExecutionContext jobExecutionContext) {
        try {
            return (ApplicationContext) jobExecutionContext.getScheduler().getContext().get("applicationContext");
        } catch (Exception e) {
            logger.error("jobExecutionContext.getScheduler().getContext().get() error!", e);
            throw new RuntimeException(e);
        }
    }
}
