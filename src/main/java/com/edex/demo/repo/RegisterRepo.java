package com.edex.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edex.demo.model.Register;

public interface RegisterRepo extends JpaRepository<Register, Integer>{

	@Query(value = "Select * from register Where fullname = :fullname AND password = :password", nativeQuery = true)
    Register findBy(String fullname, String password);
}