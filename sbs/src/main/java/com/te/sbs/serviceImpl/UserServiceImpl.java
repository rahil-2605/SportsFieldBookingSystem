package com.te.sbs.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.sbs.dto.GetUserDto;
import com.te.sbs.dto.SportsFieldDto;
import com.te.sbs.dto.UserDto;
import com.te.sbs.entity.SportsField;
import com.te.sbs.entity.User;
import com.te.sbs.exception.SomethingWentWrongException;
import com.te.sbs.exception.UserNotFoundException;
import com.te.sbs.repository.SportsFieldRepository;
import com.te.sbs.repository.UserRepository;
import com.te.sbs.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SportsFieldRepository sportsFieldRepository;

//	@Autowired
//	private ModelMapper modelMapper;

	@Override
	public GetUserDto addUser(UserDto userRegistrationDto) {
		User user = new User();
		GetUserDto getUserDto = new GetUserDto();
		BeanUtils.copyProperties(userRegistrationDto, user);
		BeanUtils.copyProperties(user, getUserDto);
		user.setRegisterDate(LocalDateTime.now());
		if (userRegistrationDto != null) {
			userRepository.save(user);
			return getUserDto;
		} else {
			throw new SomethingWentWrongException("Something Went Wrong") ;
		}

//		if (userRegistrationDto != null) {
//			return modelMapper.map(userRepository.save(modelMapper.map(userRegistrationDto, User.class)),
//					GetUserDto.class);
//		} else {
//			throw new SomethingWentWrongException("Something Went Wrong") ;
//		}

	}

	@Override
	public List<SportsFieldDto> getAllField() {
		List<SportsField> sportsFieldList = sportsFieldRepository.findAll();
		List<SportsFieldDto> getAllFieldDtoList = new ArrayList<>();
		sportsFieldList.forEach(sportsField -> {
			SportsFieldDto getAllFieldDto = new SportsFieldDto();
			BeanUtils.copyProperties(sportsField, getAllFieldDto);
			getAllFieldDtoList.add(getAllFieldDto);
		});

		return getAllFieldDtoList;
	}

	@Override
	public GetUserDto getUserById(Long userId) {
		GetUserDto getUserDto = new GetUserDto();
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user not found " + userId));

		BeanUtils.copyProperties(user, getUserDto);

		return getUserDto;

	}

}
