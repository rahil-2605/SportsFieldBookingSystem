package com.te.sbs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PaymentDto {
	
	private Long paymentId;
    private Double amount;
    private String paymentMethod;
}
