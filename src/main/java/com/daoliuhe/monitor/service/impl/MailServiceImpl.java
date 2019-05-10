package com.daoliuhe.monitor.service.impl;

import com.daoliuhe.monitor.model.MailEntity;
import com.daoliuhe.monitor.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class MailServiceImpl implements MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Resource
    private TaskExecutor taskExecutor;

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;


    @Override
    public int sendNotifyMail(String addressees, String subject, String text) {
        logger.info("sendNotifyMail subject:{} text:{}", subject, text);
        int result = 1;
        try {
            String[] tos = addressees.split(";");
            Set<String> to = new HashSet<String>(Arrays.asList(tos));
            //显示当前的ip
            SimpleMailMessage message = MailEntity.createSimpleMailMessage(subject, text, to);
            message.setFrom(from);
            taskExecutor.execute(() -> mailSender.send(message));
        } catch (Exception e) {
            logger.error("sendSimpleMail [FAIL] ex={}", e.getMessage(), e);
            result = 0;
        }
        return result;
    }
}
