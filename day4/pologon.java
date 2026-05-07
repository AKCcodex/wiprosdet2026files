package day4;

public class pologon {


    public interface Polygon {
        double getArea();


        default double getPerimeter(int... sides) {
            int sum = 0;
            for (int side : sides) {
                sum += side;
            }
            return sum;
        }


        static String shapeInfo() {
            return "This is a Polygon shape";
        }
    }


    static class Triangle implements Polygon {
        double base, height;

        Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        public double getArea() {
            return 0.5 * base * height;
        }
    }


    static class Rectangle implements Polygon {
        double length, breadth;

        Rectangle(double length, double breadth) {
            this.length = length;
            this.breadth = breadth;
        }

        public double getArea() {
            return length * breadth;
        }
    }


    public static void main(String[] args) {

        Triangle t = new Triangle(10, 5);
        Rectangle r = new Rectangle(4, 6);

        System.out.println("Triangle Area: " + t.getArea());
        System.out.println("Rectangle Area: " + r.getArea());


        System.out.println("Triangle Perimeter: " + t.getPerimeter(3, 4, 5));
        System.out.println("Rectangle Perimeter: " + r.getPerimeter(4, 6, 4, 6));


        System.out.println(Polygon.shapeInfo());
    }
}