package com.wdke.stock.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: wdk
 * Date:2018/8/3
 * Description:定时异步任务线程池配置类
 */

@Configuration
@EnableAsync
public class AsyncTaskConfig {

    @Bean("executor")
    public Executor executor(){

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(16);
        executor.setQueueCapacity(10000);
        executor.setKeepAliveSeconds(200);
        executor.setAllowCoreThreadTimeOut(true);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setThreadNamePrefix("AsyncTaskExecutor-"
        executor.initialize();
        return executor;

    }
}
