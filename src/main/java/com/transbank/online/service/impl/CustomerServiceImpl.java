package com.transbank.online.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.transbank.online.bean.Customer;
import com.transbank.online.dao.iface.CustomerDao;
import com.transbank.online.service.iface.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Override
    public List<Customer> getCustomerById(String id) {
	List<Customer> customerList = null;
	try {
	    customerList = customerDao.getCustomerById(id);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return customerList;
    }

    @Autowired
    @Qualifier("customerDao")
    public void setCustomerDao(CustomerDao customerDao) {
	this.customerDao = customerDao;
    }

}
