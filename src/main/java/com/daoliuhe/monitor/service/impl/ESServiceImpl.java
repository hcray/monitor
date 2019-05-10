package com.daoliuhe.monitor.service.impl;

import com.daoliuhe.monitor.model.Elastic;
import com.daoliuhe.monitor.model.Health;
import com.daoliuhe.monitor.properties.ESProperties;
import com.daoliuhe.monitor.service.ESService;
import com.daoliuhe.monitor.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ESServiceImpl implements ESService {
    private static final Logger logger = LoggerFactory.getLogger(ESServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MailService mailService;

    @Autowired
    ESProperties esProperties;

    @Override
    public void checkHealth() {
        logger.info("checkHealth...");
        List<Elastic> elastics = esProperties.getElastics();
        for (Elastic elastic : elastics) {
            String url = elastic.getUrl();
            String notify = elastic.getNotify();
            String environment = elastic.getEnvironment();
            Health health = getESHealth(url);
            if (null != health && "green".equalsIgnoreCase(health.getStatus())) {
                logger.info("health is green");
            } else if (null != health && "yellow".equalsIgnoreCase(health.getStatus())) {
                logger.info("health is yellow");
            } else {
                logger.info("health is error send notify email");
                String subject = environment + " elasticsearch health is error";
                String text = environment + " elasticsearch health is error " +
                        "\r\n" + "url " + url +
                        "\r\n" + "health " + health;
                mailService.sendNotifyMail(notify, subject, text);
            }
        }
    }

    @Override
    public List<Health> getHealth() {
        logger.info("getHealth...");
        List<Health> ret = new ArrayList<Health>();
        List<Elastic> elastics = esProperties.getElastics();
        for (Elastic elastic : elastics) {
            String url = elastic.getUrl();
            String environment = elastic.getEnvironment();
            Health health = getESHealth(url);
            health.setEnvironment(environment);
            health.setUrl(url);
            String status = health.getStatus();
            String style = "";
            if ("green".equals(status)) {
                style = "green";
            } else if ("yellow".equals(status)) {
                style = "yellow";
            } else {
                style = "red";
            }
            health.setStyle(style);
            ret.add(health);
        }
        return ret;
    }

    private Health getESHealth(String url) {
        logger.info("getESHealth url:{}", url);
        Health health = new Health();
        try {
              /*
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> httpEntity = new HttpEntity<String>("", headers);
            String responseStr = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class).getBody();
            logger.info("responseStr: {}", responseStr);
            */
            ResponseEntity<Health> healthResponseEntity = restTemplate.getForEntity(url, Health.class);
            if (null != healthResponseEntity) {
                health = healthResponseEntity.getBody();
            }
        } catch (Exception e) {
            logger.error("getESHealth message:{}, cause:{}, LocalizedMessage:{}", e.getMessage(), e.getCause(), e.getLocalizedMessage());
        }
        logger.info("health: {}", health);
        return health;
    }
}
