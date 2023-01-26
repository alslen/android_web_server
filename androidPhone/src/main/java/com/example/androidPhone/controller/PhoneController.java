package com.example.androidPhone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.androidPhone.model.Phone;
import com.example.androidPhone.service.PhoneService;

@RestController  // 안드로이드에 데이터를 전달하는 기능만 하기 때문에 return값이 웹페이지로 이동해서는 안됨 -> @RestController를 사용
public class PhoneController {  
	
	@Autowired
	private PhoneService phoneService;
	
	// 전체보기
	@GetMapping("/list")
	public List<Phone> list(){
		System.out.println("list");
		return phoneService.list();
	}
	
	// 추가
	@PostMapping("/insert")
	public Phone insert(@RequestBody Phone phone) { //@RequestBody : json객체를 받아오기 위해서 사용함.
		System.out.println("insert");
		return phoneService.insert(phone);
		
	}
	
	// 수정
	@PutMapping("/update/{id}")
	public Phone update(@PathVariable Long id, @RequestBody Phone phone) {
		System.out.println("update");
		return phoneService.update(id, phone);
	}
	
	// 삭제
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		System.out.println("delete");
		phoneService.delete(id);
	}
}
