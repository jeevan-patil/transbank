package com.transbank.online.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.transbank.online.bean.Customer;
import com.transbank.online.dao.iface.CustomerDao;

/**
 * 
 * @author jeevan
 * @since Apr 30, 2013
 * @purpose
 * 
 */
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    private SessionFactory sessionFactory;

    @Override
    public Customer getCustomerById(String id) throws Exception {
	Session session = sessionFactory.openSession();
	Customer customer = (Customer) session.get(Customer.class, id);
	session.flush();
	session.close();
	return customer;
    }

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

}
