package com.example.appointment.domain.model;

import com.example.appointment.domain.valueObjects.Doctor;
import com.example.appointment.domain.valueObjects.Patient;
import mk.ukim.finki.emt.sharedkernel.appointments.TimePlaceOfAppointment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;

import java.time.Duration;

@Entity
@Table(name = "appointments")
@Getter
public class Appointment extends AbstractEntity<AppointmentId> {

    private Duration appointment_duration;

    private TimePlaceOfAppointment timePlaceOfAppointment;

    @ManyToOne
    private AppointmentCategory appointmentCategory;

    private Doctor doctor;

    private Patient patient;


    public Appointment(Duration appointment_duration, TimePlaceOfAppointment timePlaceOfAppointment,
                       AppointmentCategory appointmentCategory,
                       Doctor doctor, Patient patient) {
        super(AppointmentId.randomId(AppointmentId.class));
        this.appointment_duration = appointment_duration;
        this.timePlaceOfAppointment = timePlaceOfAppointment;
        this.appointmentCategory = appointmentCategory;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Appointment() {

    }
}
