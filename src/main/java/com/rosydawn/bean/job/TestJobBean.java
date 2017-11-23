package com.rosydawn.bean.job;

import com.rosydawn.service.impl.JobServiceImpl;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Vincent on 2017-11-21.
 */
public class TestJobBean extends BaseJobBean {

    /**
     * 重写该方法来执行具体的任务操作
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobServiceImpl jobService =
                getApplicationContext(jobExecutionContext).getBean("jobService", JobServiceImpl.class);
        jobService.executeJob01();
    }

}
