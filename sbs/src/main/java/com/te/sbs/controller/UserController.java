package com.te.sbs.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.sbs.dto.BookingDto;
import com.te.sbs.dto.BookingStatusDto;
import com.te.sbs.dto.GetUserDto;
import com.te.sbs.dto.PaymentDto;
import com.te.sbs.dto.SportsFieldDto;
import com.te.sbs.response.AppResponse;
import com.te.sbs.service.BookingService;
import com.te.sbs.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private AppResponse appResponse;

	@GetMapping("/getAllField")
	@Operation(summary = "this is api is use to get all the sport field details to user")
	public ResponseEntity<AppResponse> getAllField() {
		List<SportsFieldDto> allFieldList = userService.getAllField();
		if (allFieldList != null) {
			appResponse.setError(false);
			appResponse.setMessage("Following are available field");
			appResponse.setStatus("200");
			appResponse.setData(Arrays.asList(allFieldList));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unable to fetch successfully");
			appResponse.setStatus("404");
			appResponse.setData(Arrays.asList(allFieldList));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/booking")
	@Operation(summary = "this is api to booked the sportfiled at particular time slot and date if available")
	public ResponseEntity<AppResponse> booking(@RequestBody BookingDto bookingDto) {
		Object object = bookingService.booking(bookingDto);
		appResponse.setError(false);
		appResponse.setData(Arrays.asList(object));
		appResponse.setMessage(null);
		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
	}

	@PostMapping("/{id}/payment")
	@Operation(summary = "this is api is to make the payment")
	public ResponseEntity<AppResponse> payment(@PathVariable("id") Long bookingId, @RequestBody PaymentDto paymentDto) {
		Object object = bookingService.payment(paymentDto, bookingId);
		if (object.equals("Confirmed")) {
			appResponse.setError(false);
			appResponse.setMessage("Payment Successfull");
			appResponse.setData(Arrays.asList(object));
			appResponse.setStatus("200");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("Something Went Wrong");
			appResponse.setData(Arrays.asList(object));
			appResponse.setStatus("404");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/getStatus/{id}")
	public ResponseEntity<BookingStatusDto> getStatusById(@PathVariable("id") Long bookingId) {
		BookingStatusDto bookingStatusDto=bookingService.getStatusById(bookingId);
		return new ResponseEntity<BookingStatusDto>(bookingStatusDto,HttpStatus.OK);
		 
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<AppResponse> getUserById(@PathVariable("id")Long userId){
		GetUserDto getUserDto=userService.getUserById(userId);
		if (getUserDto.getRegisterDate() != null) {
			appResponse.setError(false);
			appResponse.setMessage("Following are User Details");
			appResponse.setStatus("200");
			appResponse.setData(Arrays.asList(getUserDto));
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(true);
			appResponse.setMessage("User Not Found for this id-:"+" "+userId);
			appResponse.setStatus("404");
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
		}
		
	}

}
