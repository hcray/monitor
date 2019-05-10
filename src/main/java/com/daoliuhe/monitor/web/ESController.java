package com.daoliuhe.monitor.web;

import com.daoliuhe.monitor.model.Health;
import com.daoliuhe.monitor.service.ESService;
import com.daoliuhe.monitor.service.impl.ESServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("es")
@Controller
public class ESController {

    private static final Logger logger = LoggerFactory.getLogger(ESServiceImpl.class);

    @Autowired
    ESService esService;

    @RequestMapping("/health")
    public ModelAndView health() {
        logger.info("health");
        ModelAndView mav = new ModelAndView("work/es/health");
        List<Health> healthList = esService.getHealth();
        logger.info("healthList: {}", healthList);
        mav.addObject("rows", healthList);
        return mav;
    }

}
