package com.transbank.online.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transbank.online.bean.Customer;
import com.transbank.online.dao.iface.CustomerDao;

/**
 * 
 * @author jeevan
 * @since Apr 30, 2013
 * @purpose Custom spring security authentication class. This class implements UserDetailsService interface provide 
 * by spring security packages. Service calls underlined DAO implementation to find out user with provided credentials.
 * loadUserByUsername method returns UserDetails object with basic user information and roles.
 * 
 */

@Service("authService")
public class AuthService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    private CustomerDao customerDao;

    /**
     * method which performs authentication process
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	if (null == username || StringUtils.isEmpty(username)) {
	    try {
		throw new Exception("Customer ID is null or empty.");
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	
	System.out.println("customerDao : " + customerDao);

	Customer customer = null;
	try {
	    customer = customerDao.getCustomerById(username);
	    log.info("customer is {}", customer);
	} catch (Exception e) {
	    log.error("Exception in getting customer object in service method : {}.", e.getMessage());
	    e.printStackTrace();
	}

	if (null == customer) {
	    throw new UsernameNotFoundException("No such customer found.");
	}

	boolean enabled = true;
	boolean credentialsNonExpired = true;
	boolean accountNonExpired = true;
	boolean accountNonLocked = true;

	Collection<GrantedAuthority> authorities = getAuthorities(customer);
	User authUser = new User(customer.getUserName(),
		customer.getPassword(), enabled, accountNonExpired,
		credentialsNonExpired, accountNonLocked, authorities);

	return authUser;
    }

    /**
     * method which returns the list of customer roles
     * 
     * @param customer
     * @return
     */
    @SuppressWarnings("deprecation")
    public Collection<GrantedAuthority> getAuthorities(Customer customer) {
	List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(5);
	authList.add(new GrantedAuthorityImpl(customer.getRole()));
	return authList;
    }

    @Autowired
    @Qualifier("customerDao")
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

}
