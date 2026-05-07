package day4;

public class new1 {

    interface Movable {
        void moveUp();
        void moveDown();
        void moveLeft();
        void moveRight();
    }


    static class MovablePoint implements Movable {
        int x, y, xSpeed, ySpeed;

        MovablePoint(int x, int y, int xSpeed, int ySpeed) {
            this.x = x; this.y = y;
            this.xSpeed = xSpeed; this.ySpeed = ySpeed;
        }

        public void moveUp() { y -= ySpeed; }
        public void moveDown() { y += ySpeed; }
        public void moveLeft() { x -= xSpeed; }
        public void moveRight() { x += xSpeed; }

        public String toString() {
            return "(" + x + "," + y + ") speed=" + xSpeed + "," + ySpeed;
        }
    }

    static class MovableCircle implements Movable {
        private int radius;
        private MovablePoint center;

        MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
            this.center = new MovablePoint(x, y, xSpeed, ySpeed);
            this.radius = radius;
        }

        public void moveUp() { center.moveUp(); }
        public void moveDown() { center.moveDown(); }
        public void moveLeft() { center.moveLeft(); }
        public void moveRight() { center.moveRight(); }

        public String toString() {
            return "Circle at " + center.toString() + " radius=" + radius;
        }
    }

    static class MovableRectangle implements Movable {
        private MovablePoint topLeft;
        private MovablePoint bottomRight;

        MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
            this.topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
            this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
        }

        public void moveUp() { topLeft.moveUp(); bottomRight.moveUp(); }
        public void moveDown() { topLeft.moveDown(); bottomRight.moveDown(); }
        public void moveLeft() { topLeft.moveLeft(); bottomRight.moveLeft(); }
        public void moveRight() { topLeft.moveRight(); bottomRight.moveRight(); }

        public String toString() {
            return "Rectangle [TL=" + topLeft + ", BR=" + bottomRight + "]";
        }
    }


    public static void main(String[] args) {
        Movable p1 = new MovablePoint(5, 5, 2, 2);
        System.out.println("Point Start: " + p1);
        p1.moveRight();
        p1.moveUp();
        System.out.println("Point End:   " + p1);

        System.out.println();

        Movable c1 = new MovableCircle(10, 10, 5, 5, 20);
        System.out.println("Circle Start: " + c1);
        c1.moveDown();
        System.out.println("Circle End:   " + c1);

        System.out.println();

        Movable r1 = new MovableRectangle(0, 10, 10, 0, 3, 3);
        System.out.println("Rect Start: " + r1);
        r1.moveRight();
        r1.moveDown();
        System.out.println("Rect End:   " + r1);
    }
}