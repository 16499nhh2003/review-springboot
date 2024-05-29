package com.example.demo.repository;
import com.example.demo.model.Address;
import com.example.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

	public Admin findByEmail(String email);
}