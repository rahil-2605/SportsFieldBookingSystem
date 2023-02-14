package com.te.sbs.response;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Component
public class AppResponse {
	private boolean error;
	private String status;
	private String message;
	private Object data;

}