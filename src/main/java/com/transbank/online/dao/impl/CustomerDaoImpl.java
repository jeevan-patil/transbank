package com.transbank.online.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.transbank.online.bean.Customer;
import com.transbank.online.dao.iface.CustomerDao;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public List<Customer> getCustomerById(String id) throws Exception {
	//populate list from database here
	List<Customer> customerList = new ArrayList<Customer>();
	return customerList;
    }

}
