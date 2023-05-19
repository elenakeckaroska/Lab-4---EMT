package com.example.appointment.xport;

import com.example.appointment.domain.model.Appointment;
import com.example.appointment.domain.model.AppointmentId;
import com.example.appointment.service.AppointmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.events.appointments.ScheduleAppointment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewAppointmentListener {
    private final AppointmentService appointmentService;

    @KafkaListener(topics = TopicHolder.TOPIC_SCHEDULE_APPOINTMENT, groupId = "doctorPatient")
    public void consumeNewPatientToHospitalEvent(@Payload(required = false) String jsonMessage){
        try {
            ScheduleAppointment scheduleAppointment = DomainEvent.fromJson(jsonMessage, ScheduleAppointment.class);
            appointmentService.scheduleAppointment(scheduleAppointment.getDoctor(),
                    scheduleAppointment.getPatient(),
                    scheduleAppointment.getDuration(),
                    scheduleAppointment.getTimePlaceOfAppointment(),
                    scheduleAppointment.getAppointmentCategory());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
