package com.example.doctorpatient.doctor.services.impl;

import com.example.doctorpatient.doctor.domain.exceptions.DoctorNotFound;
import com.example.doctorpatient.doctor.domain.model.Doctor;
import com.example.doctorpatient.doctor.domain.model.DoctorId;
import com.example.doctorpatient.doctor.domain.repository.DoctorRepository;
import mk.ukim.finki.emt.sharedkernel.events.appointments.AppointmentCategory;
import com.example.doctorpatient.doctor.services.DoctorService;
import com.example.doctorpatient.doctor.services.forms.DoctorForm;
import com.example.doctorpatient.doctor.services.forms.IsDoctorRelationForm;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

import mk.ukim.finki.emt.sharedkernel.appointments.TimePlaceOfAppointment;
import mk.ukim.finki.emt.sharedkernel.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.events.appointments.Patient;
import mk.ukim.finki.emt.sharedkernel.events.appointments.PatientId;
import mk.ukim.finki.emt.sharedkernel.events.appointments.ScheduleAppointment;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final Validator validator;
    private final DomainEventPublisher domainEventPublisher;

    private Doctor toDomainObjects(DoctorForm doctorForm){
        var doctor = new Doctor(doctorForm.getPersonalData(), doctorForm.getWorkExperience());

        doctorForm.getPatients().forEach(r -> doctor.addPatient(r.getPatient()));

        return doctor;
    }
    @Override
    public DoctorId insertDoctor(DoctorForm doctorForm) {
        Objects.requireNonNull(doctorForm, "order must be null.");
                var constraintValidation = validator.validate(doctorForm);
                if (constraintValidation.size() > 0)

                    throw new ConstraintViolationException("The order form is not valid", constraintValidation);


        var newDoctor = doctorRepository.saveAndFlush(toDomainObjects(doctorForm));

        return newDoctor.getId();
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(DoctorId id)  {
        return doctorRepository.findById(id);

    }

    @Override
    public Doctor findByName(String name) {
        return doctorRepository.findByPersonalDataName(name);
    }

    @Override
    public void addPatient(DoctorId doctorId, IsDoctorRelationForm isDoctorRelationForm) {

      Doctor doctor = doctorRepository.findById(doctorId)
              .orElseThrow(DoctorNotFound::new);
      doctor.addPatient(isDoctorRelationForm.getPatient());

      doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public void scheduleAppointment(mk.ukim.finki.emt.sharedkernel.events.appointments.Doctor doctor,
                                    Patient patient, Duration duration, TimePlaceOfAppointment timePlaceOfAppointment,
                                    AppointmentCategory appointmentCategory){

        domainEventPublisher.publish(new ScheduleAppointment(doctor,
                patient, duration,
                timePlaceOfAppointment,
                appointmentCategory) {
        });

    }
}
