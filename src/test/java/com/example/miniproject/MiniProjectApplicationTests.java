package com.example.miniproject;

import com.example.miniproject.entity.Appointment;
import com.example.miniproject.entity.Doctor;
import com.example.miniproject.entity.Insurance;
import com.example.miniproject.entity.Patient;
import com.example.miniproject.repository.AppointmentRepository;
import com.example.miniproject.repository.DoctorRepository;
import com.example.miniproject.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class MiniProjectApplicationTests {

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    AppointmentRepository appointmentRepository;

    @Test
    void testCreateDoctor() {
        Doctor doctor = new Doctor();
        doctor.setFirstName("Tom");
        doctor.setLastName("Hanks");
        doctor.setSpeciality("Heart");
        doctorRepository.save(doctor);
    }

    @Test
    void testCreatePatient() {
        Patient patient = new Patient();
        patient.setFirstName("Marc");
        patient.setLastName("Tolen");
        patient.setPhone("0997627211");

        Insurance insurance = new Insurance();
        insurance.setCopay(124.2);
        insurance.setProviderName("LAN");
        patient.setInsurance(insurance);

        List<Doctor> doctors =new ArrayList<>();
        Optional<Doctor> result =  doctorRepository.findById(1L);
        Doctor doctor =result.orElse(null);
        doctors.add(doctor);
        patient.setDoctors(doctors);


        patientRepository.save(patient);
    }
    @Test
    void testCreateAppointment() {
        Appointment appointment = new Appointment();
        Timestamp timestamp = new Timestamp(new Date().getTime());
        appointment.setAppointmentTime(timestamp);
        appointment.setReason("some problem");
        appointment.setStarted(true);


        Optional<Patient> patientResult =  patientRepository.findById(1L);
        Patient patient =patientResult.orElse(null);
        appointment.setPatient(patient);

        Optional<Doctor> doctorResult =  doctorRepository.findById(1L);
        Doctor doctor =doctorResult.orElse(null);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

    }
}
