package com.learning.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Login;
import com.learning.exception.IdNotFoundException;
import com.learning.repository.LoginRepository;
import com.learning.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Login addCredentials(Login login) {
		// TODO Auto-generated method stub
		return loginRepository.save(login);
	}

	@Override
	public String deleteCredentials(String email) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Login> optional = loginRepository.findByEmail(email);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			loginRepository.deleteByEmail(email);
			return "Success";
		}
	}
	
	@Override
	public Login updateCredentials(Login login, String email) throws IdNotFoundException {
		if (loginRepository.findByEmail(email).isEmpty()) {
			throw new IdNotFoundException("Record not found");
		}
		return loginRepository.save(login);
	}


}