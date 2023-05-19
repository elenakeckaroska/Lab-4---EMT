package com.example.appointment.service;

import com.example.appointment.domain.forms.AppointmentForm;
import com.example.appointment.domain.model.Appointment;
import com.example.appointment.domain.model.AppointmentId;
import mk.ukim.finki.emt.sharedkernel.appointments.TimePlaceOfAppointment;
import mk.ukim.finki.emt.sharedkernel.events.appointments.AppointmentCategory;
import mk.ukim.finki.emt.sharedkernel.events.appointments.Patient;
import mk.ukim.finki.emt.sharedkernel.events.appointments.PatientId;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {



    List<Appointment> findAll();
    Optional<Appointment> findById(AppointmentId id);
    void scheduleAppointment(mk.ukim.finki.emt.sharedkernel.events.appointments.Doctor doctor,
                             Patient patient, Duration duration, TimePlaceOfAppointment timePlaceOfAppointment,
                             AppointmentCategory appointmentCategory);
}
