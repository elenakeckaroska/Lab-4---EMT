package com.example.appointment.domain.forms;

import com.example.appointment.domain.model.AppointmentCategory;
import com.example.appointment.domain.valueObjects.Doctor;
import com.example.appointment.domain.valueObjects.Patient;
import mk.ukim.finki.emt.sharedkernel.appointments.TimePlaceOfAppointment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Duration;

@Data
public class AppointmentForm {

    @NotNull
    private Duration appointment_duration;

    @NotNull
    private TimePlaceOfAppointment timePlaceOfAppointment;

    @Valid
    @NotNull
    private AppointmentCategory appointmentCategory;

    @NotNull
    private Doctor doctor;

    @NotNull
    private Patient patient;
}
