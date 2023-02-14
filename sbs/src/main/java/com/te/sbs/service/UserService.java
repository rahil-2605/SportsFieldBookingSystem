package com.te.sbs.service;

import java.util.List;

import com.te.sbs.dto.GetUserDto;
import com.te.sbs.dto.SportsFieldDto;
import com.te.sbs.dto.UserDto;

public interface UserService {

	public GetUserDto addUser(UserDto userRegistrationDto);

	public List<SportsFieldDto> getAllField();

	public GetUserDto getUserById(Long userId);

	

}
