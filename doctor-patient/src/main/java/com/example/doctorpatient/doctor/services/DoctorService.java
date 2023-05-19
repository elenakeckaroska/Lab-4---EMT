package com.example.doctorpatient.doctor.services;

import com.example.doctorpatient.doctor.domain.model.Doctor;
import com.example.doctorpatient.doctor.domain.model.DoctorId;
import com.example.doctorpatient.doctor.services.forms.DoctorForm;
import com.example.doctorpatient.doctor.services.forms.IsDoctorRelationForm;
import mk.ukim.finki.emt.sharedkernel.appointments.TimePlaceOfAppointment;
import mk.ukim.finki.emt.sharedkernel.events.appointments.AppointmentCategory;
import mk.ukim.finki.emt.sharedkernel.events.appointments.Patient;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public interface DoctorService {

    DoctorId insertDoctor(DoctorForm doctorForm);
    List<Doctor> findAll();
    Optional<Doctor> findById(DoctorId id);
    void addPatient(DoctorId doctorId, IsDoctorRelationForm isDoctorRelationForm);
    void scheduleAppointment(mk.ukim.finki.emt.sharedkernel.events.appointments.Doctor doctor,
                             Patient patient, Duration duration,
                             TimePlaceOfAppointment timePlaceOfAppointment,
                             AppointmentCategory appointmentCategory);
}
