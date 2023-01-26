package com.example.androidPhone.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.androidPhone.model.Phone;
import com.example.androidPhone.repository.PhoneRepository;

@Service
public class PhoneService {
	@Autowired
	private PhoneRepository phoneRepository;
	
	// 전체보기
	public List<Phone> list() {
		return phoneRepository.findAll();
	}
	
	// 추가
	public Phone insert(Phone phone) {
		return phoneRepository.save(phone);   // save를 하면 Phone객체로 반환됨
	}
	
	// 수정
	@Transactional
	public Phone update(Long id, Phone phone) {
		// 1. 영속성 컨텍스트에 들어있는 값들을 구해와야함.(id값으로)
		Phone p = phoneRepository.findById(id).get();  // 수정 되지 않은 값
		
		// 2. 객체(수정 안 된 객체)를 수정하기
		p.setName(phone.getName());
		p.setTel(phone.getTel());

		return p;
	}
	
	// 삭제
	public void delete(Long id) {
		phoneRepository.deleteById(id);
	}

}
