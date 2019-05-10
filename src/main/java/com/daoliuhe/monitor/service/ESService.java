package com.daoliuhe.monitor.service;

import com.daoliuhe.monitor.model.Health;

import java.util.List;

public interface ESService {

    /**
     * 健康检查
     *
     * @return 健康情况
     */
    void checkHealth();


    /**
     * 获取健康情况
     *
     * @return 健康情况
     */
    List<Health> getHealth();
}
