package com.te.sbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
