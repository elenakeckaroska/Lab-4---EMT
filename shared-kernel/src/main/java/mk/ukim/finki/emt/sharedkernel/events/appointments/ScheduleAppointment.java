package mk.ukim.finki.emt.sharedkernel.events.appointments;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.appointments.TimePlaceOfAppointment;
import mk.ukim.finki.emt.sharedkernel.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.events.DomainEvent;

import java.time.Duration;

@Getter
public class ScheduleAppointment extends DomainEvent {

    Doctor doctor;
    Patient patient;
    Duration duration;
    TimePlaceOfAppointment timePlaceOfAppointment;
    AppointmentCategory appointmentCategory;

    public ScheduleAppointment() {
        super(TopicHolder.TOPIC_SCHEDULE_APPOINTMENT);
    }

    public ScheduleAppointment(Doctor doctorId, Patient patientId, Duration duration, TimePlaceOfAppointment timePlaceOfAppointment,
                               AppointmentCategory appointmentCategory) {
        super(TopicHolder.TOPIC_SCHEDULE_APPOINTMENT);
        this.appointmentCategory=appointmentCategory;
        this.doctor = doctorId;
        this.patient=patientId;
        this.duration=duration;
        this.timePlaceOfAppointment = timePlaceOfAppointment;

    }


}
