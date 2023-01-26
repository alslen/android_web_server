package com.example.androidPhone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.androidPhone.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

}
