package com.daoliuhe.monitor.properties;

import com.daoliuhe.monitor.model.Elastic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("monitor-es")
public class ESProperties {

    /**
     * 配置集合
     */
    private List<Elastic> elastics;

    public List<Elastic> getElastics() {
        return elastics;
    }

    public void setElastics(List<Elastic> elastics) {
        this.elastics = elastics;
    }
}
