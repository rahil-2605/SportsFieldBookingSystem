package com.te.sbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.sbs.dto.GetUserDto;
import com.te.sbs.dto.LoginDto;
import com.te.sbs.dto.UserDto;
import com.te.sbs.response.AppResponse;
import com.te.sbs.service.LoginService;
import com.te.sbs.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class LoginAndRegisterController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private UserService userService;

	@Autowired
	private AppResponse appResponse;

	@PostMapping("/register")
	@Operation(summary = "this is api is to register the new User")
	public ResponseEntity<AppResponse> addUser(@RequestBody UserDto userRegistrationDto) {
		GetUserDto getUserDto = userService.addUser(userRegistrationDto);
		if (getUserDto != null) {
			appResponse.setError(false);
			appResponse.setMessage("User Save Successfully");
			appResponse.setStatus("200");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unable to Add Data Successfully");
			appResponse.setStatus("400");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	@Operation(summary = "this api is use to validate the user from database")
	public ResponseEntity<AppResponse> loginValidation(@RequestBody LoginDto loginDto) {
		String validation = loginService.loginValidation(loginDto);
		if (validation.equalsIgnoreCase("UserId and password is incorrect")
				|| validation.equalsIgnoreCase("No data Present")) {
			appResponse.setError(false);
			appResponse.setMessage("UserId or password is incorrect");
			appResponse.setStatus("404");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.NOT_FOUND);
		} else {
			appResponse.setError(false);
			appResponse.setMessage("Login Successfully");
			appResponse.setStatus("200");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}
	}
}
