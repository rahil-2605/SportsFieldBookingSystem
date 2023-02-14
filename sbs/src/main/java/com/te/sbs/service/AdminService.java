package com.te.sbs.service;

import java.util.List;

import com.te.sbs.dto.GetUserDto;
import com.te.sbs.dto.SportsFieldDto;
import com.te.sbs.entity.SportsField;

public interface AdminService {

	public SportsField addField(SportsFieldDto adminSportsFieldDto);

	public List<GetUserDto> getAllUser();

}
