public class Point {
    private final double x_val;
    private final double y_val;

    public Point(double x, double y) {
        this.x_val = x;
        this.y_val = y;
    }

    public double distanceTo(Point q) {
        double ans;
        ans = Math.sqrt(Math.pow(this.x_val - q.x_val, 2) + Math.pow(this.y_val - q.y_val, 2));
        return ans;
    }

    public String toString() {
        return "(" + this.x_val + ", " + this.y_val + ")";
    }

    public static void main(String[] args) {
        Point x = new Point(1, 2);
        Point y = new Point(3, 4);
        System.out.println("Distance from " + x + " to " + y + " is " + x.distanceTo(y));
    }
}