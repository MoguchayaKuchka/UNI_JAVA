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
    protected Integer salary;

    @NonNull
    protected String firstName;

    @NonNull
    protected String lastName;

    protected String middleName;

    @NonNull
    protected Integer workExperience;

    @NonNull
    protected Integer dailyWorkHours;

    @NonNull
    protected Position position;

    @NonNull
    protected Map<Position, Integer> salaryExpectations;
    @NonNull
    protected String companyName;

    public String getFullName() {
        return lastName + " " + firstName + (middleName != null ? middleName : "");
    }

    public abstract boolean isSalaryRaiseRequired();

    public abstract int getAssumedHoursOfSleep();

    public abstract void hire(String companyName, Position position, Integer salary);
}
