package com.transbank.online.controller.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author jeevan
 * @since Apr 19, 2013
 * @purpose handles core banking features
 *
 */
@Controller
public class CoreBankController {

    /**
     * cash handling
     * 
     * @return
     */
    @RequestMapping(value = "cash/handle", method = RequestMethod.GET)
    public String cashHandling() {
	return "cash/handle";
    }

}
