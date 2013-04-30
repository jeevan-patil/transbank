package com.transbank.online.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transbank.online.bean.Customer;
import com.transbank.online.dao.iface.CustomerDao;
import com.transbank.online.service.iface.CustomerService;

/**
 * 
 * @author jeevan
 * @since Apr 30, 2013
 * @purpose
 * 
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Override
    @Transactional
    public Customer getCustomerById(String id) {
	Customer customer = null;
	try {
	    customer = customerDao.getCustomerById(id);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return customer;
    }

    @Autowired
    @Qualifier("customerDao")
    public void setCustomerDao(CustomerDao customerDao) {
	this.customerDao = customerDao;
    }

}
