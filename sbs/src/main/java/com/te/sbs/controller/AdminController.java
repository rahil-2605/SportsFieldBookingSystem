package com.te.sbs.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.sbs.dto.GetUserDto;
import com.te.sbs.dto.SportsFieldDto;
import com.te.sbs.response.AppResponse;
import com.te.sbs.service.AdminService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AppResponse appResponse;

	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/addField")
	@Operation(summary = "this  api is to add the new field")
	public ResponseEntity<AppResponse> addField(@RequestBody SportsFieldDto adminSportsFieldDto) {
		Object object = adminService.addField(adminSportsFieldDto);
		if (object != null) {
			appResponse.setError(false);
			appResponse.setMessage("Field Save Successfully");
			appResponse.setStatus("200");
			appResponse.setData(Arrays.asList(object));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unable to Add Data Successfully");
			appResponse.setStatus("404");
			appResponse.setData(Arrays.asList(object));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/getAllUser")
	@Operation(summary = "this api is to get all the records of user")
	public ResponseEntity<AppResponse> getAllUser() {
		List<GetUserDto> allUserList = adminService.getAllUser();
		if (allUserList != null) {
			appResponse.setError(false);
			appResponse.setMessage("Following Are All Users Data");
			appResponse.setStatus("200");
			appResponse.setData(Arrays.asList(allUserList));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("No user Found Something Went Wrong");
			appResponse.setStatus("404");
			appResponse.setData(Arrays.asList(allUserList));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
		}

	}

}
