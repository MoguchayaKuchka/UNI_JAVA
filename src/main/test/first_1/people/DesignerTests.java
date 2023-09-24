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

class DesignerTests {

    Designer designer;
    @BeforeEach
    public void init(){
        designer = new Designer(
                700, "Borisov", "Ilya", 0,
                8, Position.JUNIOR, Map.of(
                Position.JUNIOR, 700,
                Position.MIDDLE, 1400,
                Position.SENIOR, 2000,
                Position.TEAMLEAD, 2500

        ),
                "Ya hz gde", 100, "www.google.ru", 100
        );
    }

    @Test
    void tryToSellCourse() {
        designer.tryToSellCourse();
    }

    @Test
    void testIsSalaryRaiseRequired() {
        assertFalse(designer.isSalaryRaiseRequired());
        designer.setSalary(600);
        assertTrue(designer.isSalaryRaiseRequired());
    }

    @Test
    void getAssumedHoursOfSleep() {
        assertEquals(12, designer.getAssumedHoursOfSleep());
    }

    @Test
    void hire() {
        assertThrows(SalaryException.class, () -> designer.hire(
                "Web Bee", Position.MIDDLE, 1300
        ));
        assertDoesNotThrow(()-> designer.hire(
                "Web Bee", Position.MIDDLE, 1400
        ));
    }


    @SneakyThrows
    @Test
    void testSleep() {
        String text = tapSystemOut(
                () -> designer.sleep());
        assertEquals("Let's go to party!", text.trim());

        designer.setWorkExperience(5);

        assertThrows(WorkLifeBalanceException.class, () -> designer.sleep());
    }

    @SneakyThrows
    @Test
    void testEat() {
        String text = tapSystemOut(
                () -> designer.eat()
        );
        assertEquals("Let's order some expensive food.", text.trim());

        designer.setSalary(600);

        text = tapSystemOut(
                () -> designer.eat()
        );
        assertEquals("I'm tired of eating sushi!",
                text.trim());
    }

    @SneakyThrows
    @Test
    void testHobby() {
        assertThrows(WorkLifeBalanceException.class, () -> designer.hobby());

        designer.setDailyWorkHours(4);

        String text = tapSystemOut(
                () -> designer.hobby()
        );
        assertEquals("Let's go to anime fest.", text.trim());
    }

    @Test
    void live() {
        designer.live();
    }
}