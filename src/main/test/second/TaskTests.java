package second;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class TaskTests {

    List<Student> studentList;

    @BeforeEach
    void init(){
        Student s1 = Student.builder()
                .id("1230")
                .birthdate(LocalDate.of(2003, 2, 10))
                .lastName("Bezruchenko")
                .firstName("Ivan")
                .middleName("Vitaliyevich")
                .courseAverage(0.0)
                .build();

        Student s2 = Student.builder()
                .id("1231")
                .birthdate(LocalDate.of(2002, 3, 5))
                .lastName("Bakin")
                .firstName("Roman")
                .middleName("Dmitriyevich")
                .courseAverage(5.0)
                .build();

        Student s3 = Student.builder()
                .id("1232")
                .birthdate(LocalDate.of(2003, 5, 15))
                .lastName("Leskov")
                .firstName("Dmitriy")
                .middleName("Vyacheslavovich")
                .courseAverage(5.0)
                .build();

        studentList = new ArrayList<>(List.of(s1, s2, s3));
    }
    @Test
    void firstTest() {
        //1.a
        for (Student s : studentList) {
            System.out.println(s);
        }
        System.out.println("=====================");
        //1.b
        studentList.get(2).setId("1239");
        System.out.println(studentList.get(2).getId());
        System.out.println("=====================");
        //1.c
        studentList.remove(studentList.size()-1);
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    @Test
    void secondTest() {
        //1.d
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getBirthdate().equals(o2.getBirthdate()))
                    return 0;
                if (o1.getBirthdate().isAfter(o2.getBirthdate()))
                    return 1;
                return -1;
            }
        });

        for (Student s : studentList) {
            System.out.println(s);
        }
        System.out.println("===================");
        //1.e
        studentList.removeAll(studentList);
        System.out.println(studentList.size());
    }

    @Test
    void thirdTest() {
        //2.in
        ArrayDeque<Student> queueToStolovka = new ArrayDeque<>();
        for (Student golodniy: studentList) {
            System.out.println(golodniy);
            queueToStolovka.offer(golodniy);
        }
        System.out.println("=================");
        for (Student golodniy: queueToStolovka) {
            //2.out
            System.out.println(queueToStolovka.poll());
        }
        System.out.println(queueToStolovka.size());
    }

    @Test
    void fourthTest() {
        //3.a
        HashMap<String, Double> grades = new HashMap<>();
        for (Student s : studentList) {
            grades.put(s.getFullName(), s.getCourseAverage());
        }
        Util.printEntrySet(grades);
        Util.goToNextCourse(grades);

        System.out.println("=================");
        //3.b
        Util.analysis("cbbbddaeeee");
    }
}