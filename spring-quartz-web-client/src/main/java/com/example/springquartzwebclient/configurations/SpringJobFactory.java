package com.example.springquartzwebclient.configurations;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringJobFactory extends AdaptableJobFactory {
    
    private final ApplicationContext applicationContext;

    public SpringJobFactory(final ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        
        // Instantiate the job instance
        final Object jobInstance = super.createJobInstance(bundle);
        
        // Autowire the job instance with Spring context
        applicationContext.getAutowireCapableBeanFactory().autowireBean(jobInstance);
        
        return jobInstance;
    }

}
