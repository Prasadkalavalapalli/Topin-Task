package com.topin.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topin.www.model.Topin;

@Repository
public interface TopinRepo extends JpaRepository<Topin, Long> {

}
