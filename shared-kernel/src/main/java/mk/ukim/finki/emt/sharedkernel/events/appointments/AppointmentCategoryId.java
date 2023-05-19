package mk.ukim.finki.emt.sharedkernel.events.appointments;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

@Embeddable
public class AppointmentCategoryId extends DomainObjectId {

    public AppointmentCategoryId(@NonNull String uuid) {
        super(uuid);
    }

    public AppointmentCategoryId() {
        super(PatientId.randomId(PatientId.class).getId());
    }

}