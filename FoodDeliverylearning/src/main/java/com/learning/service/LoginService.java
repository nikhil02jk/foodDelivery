package com.learning.service;

import com.learning.entity.Login;
import com.learning.exception.IdNotFoundException;

public interface LoginService {
	
	public Login addCredentials(Login login);
	public String deleteCredentials(String email) throws IdNotFoundException;
	public Login updateCredentials(Login login, String email) throws IdNotFoundException;

}