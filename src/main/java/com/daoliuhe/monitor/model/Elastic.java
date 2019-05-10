package com.daoliuhe.monitor.model;

/***
 * es配置
 */
public class Elastic {
    /**
     * 访问地址
     */
    private String url;

    /**
     * 提醒人
     */
    private String notify;

    /**
     * 系统环境
     */
    private String environment;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "Elastic{" +
                "url='" + url + '\'' +
                ", notify='" + notify + '\'' +
                ", environment='" + environment + '\'' +
                '}';
    }
}
