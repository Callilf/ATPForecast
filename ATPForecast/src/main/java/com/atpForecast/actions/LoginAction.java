/**
 * 
 */
package com.atpForecast.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Test action
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(LoginAction.class);

	private String login;
	private String password;

	public String execute() throws Exception {
		LOGGER.warn("The user with login=[" + login + "] is logging in.");
		return SUCCESS;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
