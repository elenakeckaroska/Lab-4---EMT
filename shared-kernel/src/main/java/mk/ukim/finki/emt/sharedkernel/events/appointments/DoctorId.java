package mk.ukim.finki.emt.sharedkernel.events.appointments;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class DoctorId extends DomainObjectId {
    public DoctorId() {
        super(DoctorId.randomId(DoctorId.class).getId());
    }

    public DoctorId(@NonNull String uuid) {
        super(uuid);
    }

    public static DoctorId of(@NonNull String uuid) {
        return new DoctorId(uuid);
    }
}
