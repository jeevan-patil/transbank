package com.transbank.online.controller.home;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.transbank.online.service.iface.CustomerService;

/**
 * 
 * @author jeevan
 * @since Apr 19, 2013
 * @purpose Handles requests for the application home page.
 *
 */
@Controller
public class HomeController {

    private CustomerService customerService;
    
    private static final Logger logger = LoggerFactory
	    .getLogger(HomeController.class);

    /**
     * redirects to home page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
	System.out.println("customer : " + customerService.getCustomerById("jeevan"));
	return "redirect:/landing";
    }

    /**
     * render home page
     * @return
     */
    @RequestMapping(value = "landing", method = RequestMethod.GET)
    public String landing() {
	logger.info("welcome home!");
	return "home";
    }
    
    /**
     * redirect customer to dashboard if accessed access denied page.
     * @return
     */
    @RequestMapping(value = "denied", method = RequestMethod.GET)
    public String accessDenied() {
	return "redirect:/dashboard";
    }

    @Autowired
    @Qualifier("customerService")
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
}
