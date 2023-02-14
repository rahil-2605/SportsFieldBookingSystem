package com.te.sbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.TimeSlot;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long>{

}
