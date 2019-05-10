package com.daoliuhe.monitor.job;

import com.daoliuhe.monitor.service.ESService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ESJob {

    private static final Logger logger = LoggerFactory.getLogger(ESJob.class);

    @Autowired
    ESService esService;

    @Scheduled(cron = "0 */1 * * * ?")
    public void execute() {
        logger.info("start...");
        esService.checkHealth();
    }
}
