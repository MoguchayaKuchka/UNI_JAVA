package first_1.people;

import first_1.enumeration.Position;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Data
@RequiredArgsConstructor
public abstract class Employee {

    @NonNull
    private Integer salary;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private String middleName;

    @NonNull
    private Integer workExperience;

    @NonNull
    private Integer dailyWorkHours;

    @NonNull
    private Position position;

    @NonNull
    private Map<Position, Integer> salaryExpectations;
    @NonNull
    private String companyName;

    public String getFullName() {
        return lastName + " " + firstName + (middleName != null ? middleName : "");
    }

    public abstract boolean isSalaryRaiseRequired();

    public abstract int getAssumedHoursOfSleep();

    public abstract void hire(String companyName, Position position, Integer salary);
}
