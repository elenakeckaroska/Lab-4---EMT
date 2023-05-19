package com.example.doctorpatient.service;

import com.example.doctorpatient.doctor.services.DoctorService;
import com.example.doctorpatient.patient.domain.form.PatientForm;
import com.example.doctorpatient.patient.services.PatientService;
import mk.ukim.finki.emt.sharedkernel.appointments.TimePlaceOfAppointment;
import mk.ukim.finki.emt.sharedkernel.appointments.enums.AppointmentType;
import mk.ukim.finki.emt.sharedkernel.events.appointments.*;
import mk.ukim.finki.emt.sharedkernel.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.financial.Money;
import mk.ukim.finki.emt.sharedkernel.personalInfor.PersonalData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

//    @Test
//    public void testPlaceOrder() {
//
//        IsDoctorRelationForm oi1 = new IsDoctorRelationForm();
//        oi1.setPatient(new Patient(PersonalData.valueOf("p1","p1", LocalDate.of(2001,8,1),"0108001")));
//
//
//        DoctorForm orderForm = new DoctorForm();
//        orderForm.setPersonalData(PersonalData.valueOf("d1","p1", LocalDate.of(2001,8,1),"0108001"));
//        orderForm.setPatients(Arrays.asList(oi1));
//        orderForm.setWorkExperience(LocalDate.of(2001,8,1));
//
//
//        DoctorId newOrderId = doctorService.insertDoctor(orderForm);
//        Doctor newOrder = doctorService.findById(newOrderId).orElseThrow(DoctorNotFound::new);
//        Assertions.assertEquals(newOrder.getPersonalData().getName(), "d1");
//
//    }


    @Test
    public void testNewPatientInHospital(){
        PatientForm patientForm = new PatientForm();
        patientForm.setPersonalData(PersonalData.valueOf("p1","p1", LocalDate.of(2001,8,1),"0108001"));
        patientService.insertPatient(patientForm);
    }

    @Test
    public void scheduleAppointment(){
        com.example.doctorpatient.doctor.domain.model.Doctor doctor = doctorService.findAll().stream().findFirst().get();
        Doctor doc = new Doctor(DoctorId.of(doctor.getId().getId()), doctor.getPersonalData(), doctor.getWorkExperience());

        com.example.doctorpatient.patient.domain.model.Patient patient = patientService.getAll().stream().findFirst().get();
        Patient p = new Patient(PatientId.of(patient.getId().getId()), patient.getPersonalData());
        doctorService.scheduleAppointment(doc, p, Duration.of(1, ChronoUnit.HOURS),
                new TimePlaceOfAppointment(5, "5B", LocalDateTime.now()),
                new AppointmentCategory(Money.valueOf(Currency.MKD, 1000), AppointmentType.EYE_EXAM));
    }
}

