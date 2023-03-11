package com.example.miniproject.repository;

import com.example.miniproject.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor,Long> {
}
