package first_1.people;

import first_1.enumeration.Position;
import first_1.exception.SalaryException;
import first_1.exception.WorkLifeBalanceException;
import first_1.interfaces.Liveable;
import lombok.NonNull;

import java.util.Map;


public class Programmer extends Employee implements Liveable {
    private String programmingLanguage;

    public Programmer(Integer salary, String firstName,
                      String lastName, Integer workExperience,
                      Integer dailyWorkHours, Position position,
                      Map<Position, Integer> salaryExpectations,
                      String companyName,
                      String programmingLanguage) {
        super(salary, firstName, lastName, workExperience, dailyWorkHours,
                position, salaryExpectations, companyName);
        this.programmingLanguage = programmingLanguage;
    }

    public void introduceOnInterview() {
        System.out.println("Hi, My name is " + getFullName() + ". I'm a " + position.name() +
                " " + programmingLanguage +" developer with " + workExperience + " years of" +
                "experience.");
    }
    @Override
    public boolean isSalaryRaiseRequired() {
        return !programmingLanguage.equals("PHP") &&
                salaryExpectations.getOrDefault(position, 1000) > salary;
    }

    @Override
    public int getAssumedHoursOfSleep() {
        return 8 - workExperience;
    }

    @Override
    public void hire(String companyName, Position position, Integer salary) {
        if (salary < salaryExpectations.getOrDefault(position, 1000)) {
            throw new SalaryException("I'll call u");
        }
        setCompanyName(companyName);
        setPosition(position);
        setSalary(salary);
    }

    @Override
    public void sleep() {
        System.out.println(getAssumedHoursOfSleep() < 4 && isSalaryRaiseRequired()
                ? "Oh, i'm better to finish this task instead of sleeping"
                : "Let's go to sleep");
    }

    @Override
    public void work() {
        System.out.println("Oh, another sprint((");
    }

    @Override
    public void eat() {
        System.out.println(isSalaryRaiseRequired()
        ? "I'm tired of eating Doshirak!"
        : "Let's order some food.");
    }

    @Override
    public void hobby() throws WorkLifeBalanceException{
        if (24 - getAssumedHoursOfSleep() - dailyWorkHours < 5) {
            throw new WorkLifeBalanceException("I wanna ask for a promotion");
        }
        System.out.println("Let's go to MTG tournament.");
    }

    @Override
    public void live() {
        work();
        eat();
        try{
            hobby();
        } catch (WorkLifeBalanceException e) {
            System.out.println(e.getMessage());
        }
        sleep();
    }
}
