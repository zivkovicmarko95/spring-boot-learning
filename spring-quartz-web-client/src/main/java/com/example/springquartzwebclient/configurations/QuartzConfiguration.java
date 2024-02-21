package com.example.springquartzwebclient.configurations;

import java.io.IOException;

import com.example.springquartzwebclient.jobs.BookerJob;
import com.example.springquartzwebclient.jobs.SwapiJob;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfiguration {

    private final SpringJobFactory springJobFactory;

    public QuartzConfiguration(final SpringJobFactory springJobFactory) {
        this.springJobFactory = springJobFactory;
    }

    @Bean
    SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        
        final SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(springJobFactory);
        
        return schedulerFactoryBean;
    }
    
    @Bean
    JobDetailFactoryBean bookerJobDetail() {
        
        return this.createJobDetail(BookerJob.class);
    }

    @Bean
    JobDetailFactoryBean swapiJobDetail() {

        return this.createJobDetail(SwapiJob.class);
    }

    @Bean
    CronTriggerFactoryBean bookerTrigger(@Qualifier("bookerJobDetail") final JobDetail jobDetail) {

        return this.createCronTrigger(jobDetail, "0/10 * * * * ?");
    }

    @Bean
    CronTriggerFactoryBean swapiTrigger(@Qualifier("swapiJobDetail") final JobDetail jobDetail) {

        return this.createCronTrigger(jobDetail, "0/10 * * * * ?");
    }

    @Bean
    SchedulerFactoryBean scheduler(@Qualifier("bookerTrigger") final CronTrigger bookerTrigger,
            @Qualifier("swapiTrigger") final CronTrigger swapiTrigger) {
        
        final SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(springJobFactory);
        schedulerFactoryBean.setTriggers(bookerTrigger, swapiTrigger);
        
        return schedulerFactoryBean;
    }

    private CronTriggerFactoryBean createCronTrigger(final JobDetail jobDetail, final String cronExpression) {
        final CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();

        factoryBean.setJobDetail(jobDetail);
        factoryBean.setName(
            String.format("Trigger for %s", jobDetail.getJobClass().getName())
        );
        factoryBean.setCronExpression(cronExpression);
        
        return factoryBean;
    }

    private JobDetailFactoryBean createJobDetail(final Class<? extends Job> jobClass) {
        
        final JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();

        factoryBean.setJobClass(jobClass);
        factoryBean.setDurability(true);
        factoryBean.setName(jobClass.getName());

        return factoryBean;
    }

}
