package mk.ukim.finki.emt.sharedkernel.events.appointments;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.appointments.enums.AppointmentType;
import mk.ukim.finki.emt.sharedkernel.base.ValueObjectInterface;
import mk.ukim.finki.emt.sharedkernel.financial.Money;

@Getter
public class AppointmentCategory implements ValueObjectInterface {

    private final AppointmentCategoryId id;
    private Money price;

    @Enumerated(EnumType.STRING)
    private AppointmentType appointmentType;

    @JsonCreator
    public AppointmentCategory(@JsonProperty("price") Money price,
                               @JsonProperty("appointmentType") AppointmentType appointmentType) {
        this.id = AppointmentCategoryId.randomId(AppointmentCategoryId.class);

        this.appointmentType = appointmentType;
        this.price = price;
    }

//    public AppointmentCategory(Money money, AppointmentType type) {
//        this.id = AppointmentCategoryId.randomId(AppointmentCategoryId.class);
//        this.appointmentType = type;
//        this.price = money;
//    }
}

