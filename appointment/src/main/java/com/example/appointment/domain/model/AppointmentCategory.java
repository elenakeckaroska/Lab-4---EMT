package com.example.appointment.domain.model;

import jakarta.persistence.*;
import mk.ukim.finki.emt.sharedkernel.appointments.enums.AppointmentType;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.financial.Money;

//@Entity
//@Table(name = "appointment_categories")
@Embeddable

@Getter
public class AppointmentCategory{

    @Column(name = "price", table = "appointments")
    private Money price;

    @Column(name = "appointmentType", table = "appointments")
    @Enumerated(EnumType.STRING)
    private AppointmentType appointmentType;


    public AppointmentCategory(Money price, AppointmentType appointmentType) {
//        super(AppointmentCategoryId.randomId(AppointmentCategoryId.class));
        this.appointmentType = appointmentType;
        this.price = price;
    }

    public AppointmentCategory() {

    }
}
