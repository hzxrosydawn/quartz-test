package com.rosydawn.service.impl;

import com.rosydawn.service.SimpleService;
import org.apache.log4j.Logger;

/**
 * Created by Vincent on 2017-11-21.
 */
public class SimpleServiceImpl implements SimpleService {
    private static final Logger LOGGER = Logger.getLogger(SimpleServiceImpl.class);

    @Override
    public void executeFirstSimpleJob(String triggerDescription) {
        LOGGER.info("执行" + triggerDescription +  "trigger");
    }

    @Override
    public void executeSecondSimpleJob() {
        LOGGER.info("执行第二个简单任务");
    }
}
