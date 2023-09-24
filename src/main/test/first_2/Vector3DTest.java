package first_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Vector3DTest {
    Vector3D vec1;

    Vector3D vec2;

    @BeforeEach
    public void init(){
        vec1 = new Vector3D(1, 2, 3);
        vec2 = new Vector3D(5, 8, -1);
    }

    @Test
    void length() {
        System.out.println(vec1.length());
        System.out.println(vec2.length());
    }

    @Test
    void scalarMult() {
        System.out.println(vec1.scalarMult(vec2));
    }

    @Test
    void vectorMult() {
        System.out.println(vec1.vectorMult(vec2));
        System.out.println(vec2.vectorMult(vec1));
    }

    @Test
    void angle() {
        System.out.println(vec1.angle(vec2));
        System.out.println(vec2.angle(vec1));
    }

    @Test
    void sumOfTwoVectors() {
        System.out.println(Vector3D.sumOfTwoVectors(vec1, vec2));
    }

    @Test
    void distOfTwoVectors() {
        System.out.println(Vector3D.distOfTwoVectors(vec1, vec2));
    }

    @Test
    void generateRandomVectors() {
        Vector3D [] vectors = Vector3D.generateRandomVectors(100);
        for (int i = 0; i < 100; i++) {
            System.out.println(vectors[i]);
        }
    }
}