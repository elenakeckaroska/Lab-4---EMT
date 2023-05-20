package mk.ukim.finki.emt.sharedkernel.appointments.forms;


import mk.ukim.finki.emt.sharedkernel.appointments.TimePlaceOfAppointment;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.events.appointments.AppointmentCategory;
import mk.ukim.finki.emt.sharedkernel.events.appointments.Doctor;
import mk.ukim.finki.emt.sharedkernel.events.appointments.Patient;

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
