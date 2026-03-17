package com.example.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.Division;

@CrossOrigin("http://localhost:4200")
public interface DivisionRepository extends JpaRepository<Division, Long> {

}
