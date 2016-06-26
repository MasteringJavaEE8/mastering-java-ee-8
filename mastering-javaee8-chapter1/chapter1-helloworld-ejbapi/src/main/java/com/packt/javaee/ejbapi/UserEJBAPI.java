package com.packt.javaee.ejbapi;

import java.util.Map;

import com.packt.javaee.exception.MessageException;
import com.packt.javaee.jpa.User;

public interface UserEJBAPI {
	
	public void insertUserDetails(String user_name, String user_job_role) throws MessageException;
	
	public User getUserDetails() throws MessageException;
	


}
