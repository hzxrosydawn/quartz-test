package com.rosydawn.service;

import org.quartz.TriggerKey;

/**
 * Created by Vincent on 2017-11-21.
 */
public interface SchedulerService {
    void updateTrigger(TriggerKey triggerKey);
}
