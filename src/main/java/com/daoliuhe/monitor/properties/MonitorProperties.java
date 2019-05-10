package com.daoliuhe.monitor.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The class Paascloud properties.
 *
 * @author 21829
 */
@ConfigurationProperties(prefix = "monitor")
public class MonitorProperties {

    private AsyncTaskProperties task = new AsyncTaskProperties();

    public AsyncTaskProperties getTask() {
        return task;
    }

    public void setTask(AsyncTaskProperties task) {
        this.task = task;
    }

}
