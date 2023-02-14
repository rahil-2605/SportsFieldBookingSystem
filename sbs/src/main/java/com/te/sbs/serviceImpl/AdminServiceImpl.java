package com.te.sbs.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.sbs.dto.GetUserDto;
import com.te.sbs.dto.SportsFieldDto;
import com.te.sbs.entity.SportsField;
import com.te.sbs.entity.User;
import com.te.sbs.repository.SportsFieldRepository;
import com.te.sbs.repository.UserRepository;
import com.te.sbs.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private SportsFieldRepository sportsfieldRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public SportsField addField(SportsFieldDto adminSportsFieldDto) {
		SportsField sportsField = new SportsField();
		BeanUtils.copyProperties(adminSportsFieldDto, sportsField);
		sportsfieldRepository.save(sportsField);
		return sportsField;
	}

	@Override
	public List<GetUserDto> getAllUser() {
		List<User> userList = userRepository.findAll();
		List<GetUserDto> userListDto = new ArrayList<>();
		userList.forEach(user -> {
			GetUserDto getUserDto = new GetUserDto();
			BeanUtils.copyProperties(user, getUserDto);
			userListDto.add(getUserDto);
		});
		return userListDto;
	}

}
