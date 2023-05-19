package com.example.doctorpatient.doctor.xport;

import com.example.doctorpatient.doctor.domain.model.DoctorId;
import mk.ukim.finki.emt.sharedkernel.events.appointments.Patient;
import com.example.doctorpatient.doctor.services.DoctorService;
import com.example.doctorpatient.doctor.services.forms.IsDoctorRelationForm;
import com.example.doctorpatient.patient.xport.event.NewPatientInHospital;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NewPatientInHospitalHandler {

    private final DoctorService doctorService;

    @EventListener
    public void onNewPatient(NewPatientInHospital patient){
        DoctorId doctorId = doctorService.findAll().stream().findFirst().get().getId();
        IsDoctorRelationForm relation = new IsDoctorRelationForm(new Patient(patient.getPatient().getPersonalData()));

        this.doctorService.addPatient(doctorId, relation);
    }
}
