package mk.ukim.finki.emt.sharedkernel.personalInfor;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.base.ValueObjectInterface;


import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@Getter
public class PersonalData implements ValueObjectInterface {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String embg;

    public PersonalData(@NonNull String name, @NonNull String surname,@NonNull LocalDate dateOfBirth,
                        @NonNull String embg) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.embg = embg;
    }

    public PersonalData() {

    }

    public String personNameAndSurname(){
        return name + " " + surname;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalData that = (PersonalData) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(dateOfBirth, that.dateOfBirth)
                && Objects.equals(embg, that.embg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, dateOfBirth, embg);
    }


    public static PersonalData valueOf(String name,  String surname, LocalDate dateOfBirth,
                                 String embg){
        return new PersonalData(name, surname, dateOfBirth, embg);
    }
}
