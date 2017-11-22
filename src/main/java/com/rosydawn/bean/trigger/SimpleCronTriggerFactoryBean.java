package com.rosydawn.bean.trigger;

import com.rosydawn.mapper.TriggerMapper;
import org.apache.log4j.Logger;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

/**
 * Created by Vincent on 2017-11-21.
 */
public class SimpleCronTriggerFactoryBean extends CronTriggerFactoryBean {
    private static final Logger logger = Logger.getLogger(SimpleCronTriggerFactoryBean.class);

    private TriggerMapper triggerMapper;


}
