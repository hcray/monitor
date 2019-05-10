package com.daoliuhe.monitor.config;

import com.daoliuhe.monitor.properties.MonitorProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * The class Async config.
 * 异步线程执行
 *
 * @author 21829
 */
@Configuration
@EnableAsync
@EnableScheduling
public class AsyncTaskExecutorConfiguration implements AsyncConfigurer {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private MonitorProperties monitorProperties;

    @Override
    @Bean(name = "taskExecutor")
    public Executor getAsyncExecutor() {
        log.debug("Creating Async Task Executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(monitorProperties.getTask().getCorePoolSize());
        executor.setMaxPoolSize(monitorProperties.getTask().getMaxPoolSize());
        executor.setQueueCapacity(monitorProperties.getTask().getQueueCapacity());
        executor.setKeepAliveSeconds(monitorProperties.getTask().getKeepAliveSeconds());
        executor.setThreadNamePrefix(monitorProperties.getTask().getThreadNamePrefix());
        return new ExceptionHandlingAsyncTaskExecutor(executor);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
