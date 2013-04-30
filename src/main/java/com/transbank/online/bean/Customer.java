package com.transbank.online.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author jeevan
 * @since Apr 30, 2013
 * @purpose hibernate pojo for user table
 *
 */

@Entity
@Table(name = "user", schema = "bank")
public class Customer implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9186357723906698510L;

    @Id
    @Column(name = "username")
    private String userName;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "role")
    private String role;

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    @Override
    public String toString() {
	return "Customer [userName=" + userName + ", role=" + role + "]";
    }

}
