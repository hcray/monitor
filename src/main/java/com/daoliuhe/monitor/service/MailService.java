package com.daoliuhe.monitor.service;

public interface MailService {
    /**
     * 发送邮件
     *
     * @param addressees 收件人
     * @param subject    主题
     * @param text       内容
     * @return
     */
    int sendNotifyMail(String addressees, String subject, String text);
}
