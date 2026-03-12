package com.example.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.Vacation;
@CrossOrigin("http://localhost:4200")
public interface vacationRepository extends JpaRepository<Vacation, Long> {

}
