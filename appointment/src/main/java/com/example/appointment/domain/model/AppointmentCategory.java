package com.example.appointment.domain.model;

import mk.ukim.finki.emt.sharedkernel.appointments.enums.AppointmentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.financial.Money;

@Entity
@Table(name = "appointment_categories")
@Getter
public class AppointmentCategory extends AbstractEntity<AppointmentCategoryId> {

    private Money price;

    @Enumerated(EnumType.STRING)
    private AppointmentType appointmentType;


    public AppointmentCategory(Money price, AppointmentType appointmentType) {
        super(AppointmentCategoryId.randomId(AppointmentCategoryId.class));
        this.appointmentType = appointmentType;
        this.price = price;
    }

    public AppointmentCategory() {

    }
}
