package mk.ukim.finki.emt.sharedkernel.events.appointments;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

import jakarta.persistence.*;

@Embeddable
public class PatientId extends DomainObjectId {

    public PatientId(@NonNull String uuid) {
        super(uuid);
    }

    public PatientId() {
        super(PatientId.randomId(PatientId.class).getId());
    }
    public static PatientId of(@NonNull String uuid) {
        return new PatientId(uuid);
    }
}
