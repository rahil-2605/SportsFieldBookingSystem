package com.te.sbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String bookingDate;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private SportsField sportsField;
	
	@ManyToOne
	private TimeSlot timeSlot;
	
	@ManyToOne
	private BookingStatus bookingStatus;
	
	@OneToOne
	private Payment payment;
	
	

}
