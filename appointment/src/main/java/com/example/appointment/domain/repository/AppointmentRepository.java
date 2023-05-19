package com.example.appointment.domain.repository;

import com.example.appointment.domain.model.Appointment;
import com.example.appointment.domain.model.AppointmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {

}
