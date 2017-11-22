package com.rosydawn.bean.job;

import com.rosydawn.service.SimpleService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.Serializable;

/**
 * Created by Vincent on 2017-11-21.
 */
public class FirstSimpleJobBean extends QuartzJobBean implements Serializable {
    private SimpleService simpleService;

    /**
     * 重写该方法来执行具体的任务操作
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Trigger trigger = jobExecutionContext.getTrigger();
        String triggerDescription = trigger.getDescription();
        simpleService.executeFirstSimpleJob(triggerDescription);
    }

    public SimpleService getSimpleService() {
        return simpleService;
    }

    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }
}
