package com.te.sbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.SportsField;

@Repository
public interface SportsFieldRepository extends JpaRepository<SportsField, Long>{

}
