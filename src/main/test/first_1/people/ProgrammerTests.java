package first_1.people;

import first_1.enumeration.Position;
import first_1.exception.SalaryException;
import first_1.exception.WorkLifeBalanceException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgrammerTests {

    static Programmer programmer;
    @BeforeEach
    public void init(){
        programmer = new Programmer(
                1500, "Bezruchenko", "Ivan", 1,
                8, Position.JUNIOR, Map.of(
                Position.JUNIOR, 1500,
                Position.MIDDLE, 2500,
                Position.SENIOR, 4000,
                Position.TEAMLEAD, 6000

            ),
                "JAVA", "CloudCom"
        );
    }
    @Test
    public void testIntroduceOnInterview() {
        programmer.introduceOnInterview();
    }

    @Test
    public void testIsSalaryRaiseRequired() {
        assertFalse(programmer.isSalaryRaiseRequired());
        programmer.setSalary(1200);
        assertTrue(programmer.isSalaryRaiseRequired());
    }

    @Test
    public void testGetAssumedHoursOfSleep() {
        assertEquals(7, programmer.getAssumedHoursOfSleep());
    }

    @Test
    public void testHire() {
        assertThrows(SalaryException.class, () -> programmer.hire(
                "Web Bee", Position.MIDDLE, 2000)
        );
        assertDoesNotThrow(()-> programmer.hire(
                "Web Bee", Position.MIDDLE, 2500
        ));
    }

    @Test
    public void testLive() {
        programmer.setDailyWorkHours(13);
        programmer.live();
    }

    @SneakyThrows
    @Test
    void testSleep() {
        String text = tapSystemOut(
                () -> programmer.sleep());
        assertEquals("Let's go to sleep", text.trim());

        programmer.setSalary(1200);
        programmer.setWorkExperience(5);

        text = tapSystemOut(
                () -> programmer.sleep()
        );
        assertEquals("Oh, i'm better to finish this task instead of sleeping",
                text.trim());
    }

    @SneakyThrows
    @Test
    void testEat() {
        String text = tapSystemOut(
                () -> programmer.eat()
        );
        assertEquals("Let's order some food.", text.trim());

        programmer.setSalary(1200);

        text = tapSystemOut(
                () -> programmer.eat()
        );
        assertEquals("I'm tired of eating Doshirak!",
                text.trim());
    }

    @SneakyThrows
    @Test
    void testHobby() {
        String text = tapSystemOut(
                () -> programmer.hobby()
        );
        assertEquals("Let's go to MTG tournament.", text.trim());

        programmer.setDailyWorkHours(13);
        assertThrows(WorkLifeBalanceException.class, () -> programmer.hobby());
    }
}