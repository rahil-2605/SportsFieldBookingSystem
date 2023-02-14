package com.te.sbs.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.sbs.dto.LoginDto;
import com.te.sbs.entity.User;
import com.te.sbs.exception.UserIdOrPasswordIncorrectException;
import com.te.sbs.repository.UserRepository;
import com.te.sbs.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	public String loginValidation(LoginDto loginDto) {
		User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(
				() -> new UserIdOrPasswordIncorrectException("UserId Or Password is incorrect " + loginDto.getEmail()));

		if (user.getEmail().equals(loginDto.getEmail()) && user.getPassword().equals(loginDto.getPassword())) {
			return "Login Successfully";
		} else {
			return "UserId and password is incorrect";
		}
	}

}
