package com.edex.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edex.demo.model.Register;
import com.edex.demo.repo.RegisterRepo;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/user")
public class RegisterController {
	@Autowired
	private RegisterRepo registerrepo;
	
	
	@PostMapping("/register")
	public ResponseEntity<?> adduser(@RequestBody Register register) {
		Register savedEntity = registerrepo.saveAndFlush(register);
		System.out.print(savedEntity);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(savedEntity);
		
	}
	
//	@PostMapping("/logincheck")
//  
//  public ResponseEntity<?> logincheck(@RequestParam String fullname, String password){
//		Register register = registerrepo.findBy(fullname, password);
//    return ResponseEntity.status(HttpStatus.OK)
//            .body(register);
//      
//  }
	
	@PostMapping("/logincheck")
//  @CrossOrigin(origins = "http://localhost:3000")
  
  public ResponseEntity<?> logincheck(@RequestBody Register register){
      
      System.out.println(register.getFullname());
      
      String a = register.getFullname();
      String b = register.getPassword();
               
      Register log = registerrepo.findBy(a, b);
    
    return ResponseEntity.status(HttpStatus.OK)
            .body(log);
      
  }
	
	
	
}
