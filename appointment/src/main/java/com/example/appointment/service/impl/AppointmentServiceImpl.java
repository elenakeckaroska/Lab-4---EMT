package com.example.appointment.service.impl;

import com.example.appointment.domain.model.Appointment;
import com.example.appointment.domain.model.AppointmentId;
import com.example.appointment.domain.repository.AppointmentRepository;
import com.example.appointment.domain.valueObjects.DoctorId;
import com.example.appointment.domain.valueObjects.PatientId;
import com.example.appointment.service.AppointmentService;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.appointments.TimePlaceOfAppointment;
import mk.ukim.finki.emt.sharedkernel.events.appointments.AppointmentCategory;
import mk.ukim.finki.emt.sharedkernel.events.appointments.Patient;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;


    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> findById(AppointmentId id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void scheduleAppointment(mk.ukim.finki.emt.sharedkernel.events.appointments.Doctor doctor,
                                    Patient patient, Duration duration, TimePlaceOfAppointment timePlaceOfAppointment,
                                    AppointmentCategory appointmentCategory) {

        com.example.appointment.domain.model.AppointmentCategory appointmentCategory1 = new com.example.appointment.domain.model.AppointmentCategory(
                appointmentCategory.getPrice(),  appointmentCategory.getAppointmentType());

        com.example.appointment.domain.valueObjects.Doctor doctor1 = new com.example.appointment.domain.valueObjects.Doctor(new DoctorId(doctor.getId().getId()),
                doctor.getPersonalData(), doctor.getWorkExperience());
        com.example.appointment.domain.valueObjects.Patient patient1 = new com.example.appointment.domain.valueObjects.Patient(new PatientId(patient.getId().getId()), patient.getPersonalData());
        Appointment appointment = new Appointment(duration, timePlaceOfAppointment, appointmentCategory1, doctor1, patient1 );
        appointmentRepository.saveAndFlush(appointment);

    }
}
