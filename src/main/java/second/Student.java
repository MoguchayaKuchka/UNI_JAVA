package second;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@Builder
public class Student {
    @Pattern(regexp = "\\d{4}")
    @NonNull
    String id;

    @NonNull
    String lastName;

    @NonNull
    String firstName;

    @NonNull
    String middleName;

    @NonNull
    LocalDate birthdate;

    @NonNull
    Double courseAverage;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthdate=" + birthdate +
                ", courseAverage=" + courseAverage +
                '}';
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }
}
