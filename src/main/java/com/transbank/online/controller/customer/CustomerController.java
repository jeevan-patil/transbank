package com.transbank.online.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.transbank.online.bean.Customer;
import com.transbank.online.service.iface.CustomerService;

@Controller
public class CustomerController {

    private CustomerService customerService;
    
    /**
     * adding customer
     * 
     * @return
     */
    @RequestMapping(value = "customer/add", method = RequestMethod.GET)
    public String addCustomer() {
	return "customer/add";
    }

    /**
     * view customer info
     * 
     * @return
     */
    @RequestMapping(value = "customer/view", method = RequestMethod.GET)
    public String viewCustomer(Model model) {
	List<Customer> custList = customerService.getCustomerById("007bond");
	model.addAttribute("customerList", custList);
	return "customer/view";    
    }

    @Autowired
    @Qualifier("customerService")
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
}
