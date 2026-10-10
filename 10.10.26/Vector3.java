public class Vector3 {
    private double x;
    private double y;
    private double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Vector3 add(Vector3 other) {
        return new Vector3(this.x + other.getX(), this.y + other.getY(), this.z + other.getZ());
    }

    public Vector3 subtract(Vector3 other) {
        return new Vector3(this.x - other.getX(), this.y - other.getY(), this.z - other.getZ());
    }

    public double dot(Vector3 other) {
        return this.x * other.getX() + this.y * other.getY() + this.z * other.getZ();
    }

    public Vector3 multiply(double scalar) {
        return new Vector3(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        Vector3 a = new Vector3(1, 2, 3);
        Vector3 b = new Vector3(4, 5, 6);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.subtract(b));
        System.out.println("a · b = " + a.dot(b));
        System.out.println("a * 2 = " + a.multiply(2));

        a.setX(10);
        a.setY(20);
        a.setZ(30);

        System.out.println();
        System.out.println("после set:");
        System.out.println("a = " + a);
        System.out.println("a.x = " + a.getX());
        System.out.println("a.y = " + a.getY());
        System.out.println("a.z = " + a.getZ());
    }
}