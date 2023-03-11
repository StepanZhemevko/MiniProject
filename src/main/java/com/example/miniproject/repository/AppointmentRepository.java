package com.example.miniproject.repository;

import com.example.miniproject.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment,Long> {
}
