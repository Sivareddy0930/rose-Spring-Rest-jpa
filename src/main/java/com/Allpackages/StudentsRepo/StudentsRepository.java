package com.Allpackages.StudentsRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Allpackages.entity.Students;


@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
		
//	public Students  findByStudent_Name(String name);
	
	
}
