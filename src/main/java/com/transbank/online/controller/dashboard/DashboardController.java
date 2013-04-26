package com.transbank.online.controller.dashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author jeevan
 * @since Apr 19, 2013
 * @purpose Controller responsible for dashboard.
 *
 */
@Controller
public class DashboardController {
    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public String dashboard() {
	log.info("on dashboard");
	return "dashboard";
    }
}
