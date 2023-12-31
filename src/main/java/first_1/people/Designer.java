package first_1.people;

import first_1.enumeration.Position;
import first_1.exception.SalaryException;
import first_1.exception.WorkLifeBalanceException;
import first_1.interfaces.Liveable;
import lombok.NonNull;

import java.util.Map;

public class Designer extends Employee implements Liveable {

    private Integer coursePrice;

    private String courseLink;

    private int subsCount;
    public Designer(Integer salary, String firstName,
                    String lastName, Integer workExperience,
                    Integer dailyWorkHours, Position position,
                    Map<Position, Integer> salaryExpectations,
                    String companyName,
                    Integer coursePrice, String courseLink,
                    int subsCount) {
        super(salary, firstName, lastName, workExperience,
                dailyWorkHours, position, salaryExpectations, companyName);
        this.coursePrice = coursePrice;
        this.courseLink = courseLink;
        this.subsCount = subsCount;
    }

    public void tryToSellCourse() {
        System.out.println("Hi everyone! Today is the last day to entry my personal design course for " +
                "only " + coursePrice + "$! Go to " + courseLink + " and take your chance to start" +
                " a new career!");
    }

    @Override
    public boolean isSalaryRaiseRequired() {
        return subsCount < 100_000
                && salaryExpectations.getOrDefault(position, 700) > salary;
    }

    @Override
    public int getAssumedHoursOfSleep() {
        return 12 - workExperience;
    }

    @Override
    public void hire(String companyName, Position position, Integer salary) {
        if (salary < salaryExpectations.getOrDefault(position, 700)
            && subsCount < 100_000) {
            throw new SalaryException("I'll think about it");
        }
        setCompanyName(companyName);
        setPosition(position);
        setSalary(salary);
    }

    @Override
    public void sleep() {
        if (getAssumedHoursOfSleep() < 8) {
            throw new WorkLifeBalanceException("I wanna ask for a promotion");
        }
        System.out.println("Let's go to party!");
    }

    @Override
    public void work() {
        System.out.println("Oh, another day of drinking coffee");
    }

    @Override
    public void eat() {
        System.out.println(isSalaryRaiseRequired()
                ? "I'm tired of eating sushi!"
                : "Let's order some expensive food.");
    }

    @Override
    public void hobby() throws WorkLifeBalanceException{
        if (24 - getAssumedHoursOfSleep() - dailyWorkHours < 8) {
            throw new WorkLifeBalanceException("I won't survive without anime");
        }
        System.out.println("Let's go to anime fest.");
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
