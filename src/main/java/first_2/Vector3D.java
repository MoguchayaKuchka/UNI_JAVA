package first_2;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double scalarMult(Vector3D v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector3D vectorMult(Vector3D v) {
        double tmpX = y * v.z - z * v.y;
        double tmpY = z * v.x - x * v.z;
        double tmpZ = x * v.y - y * v.x;
        return new Vector3D(tmpX, tmpY, tmpZ);
    }

    public double angle(Vector3D v1) {
        try {
            return scalarMult(v1) / (length() * v1.length());
        } catch (ArithmeticException e)
        {
            return scalarMult(v1);
        }
    }

    public static Vector3D sumOfTwoVectors(Vector3D v1, Vector3D v2) {
        return new Vector3D(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    public static Vector3D distOfTwoVectors(Vector3D v1, Vector3D v2) {
        return new Vector3D(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    public static Vector3D[] generateRandomVectors(int n) {
        Vector3D [] vectors = new Vector3D[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector3D(Math.random() * 200 - 100,
                    Math.random() * 200 - 100,
                    Math.random() * 200 - 100);
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "{" + x + "; " + y + "; " + z + "}";
    }
}
