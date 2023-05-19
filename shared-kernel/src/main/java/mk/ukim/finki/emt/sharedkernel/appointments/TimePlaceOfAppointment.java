package mk.ukim.finki.emt.sharedkernel.appointments;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.ValueObjectInterface;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
@Getter
public class TimePlaceOfAppointment implements ValueObjectInterface {

    private Integer floor;
    private String room;
    private LocalDateTime time;


    public TimePlaceOfAppointment(@NonNull Integer floor,
                                  @NonNull String room,
                                  @NonNull LocalDateTime time
    ) {
        this.floor = floor;
        this.room = room;
        this.time = time;
    }

    public TimePlaceOfAppointment() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimePlaceOfAppointment that = (TimePlaceOfAppointment) o;
        return Objects.equals(floor, that.floor) && Objects.equals(room, that.room) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floor, room, time);
    }

    public static TimePlaceOfAppointment valueOf(Integer floor, String room,LocalDateTime time) {
        return new TimePlaceOfAppointment(floor, room, time);
    }
}
