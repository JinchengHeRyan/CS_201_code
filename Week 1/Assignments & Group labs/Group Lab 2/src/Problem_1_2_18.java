public class Problem_1_2_18 {
    public static void main(String[] args) {
        double x,y, Euclidean_distance;
        x = Double.parseDouble(args[0]);
        y = Double.parseDouble(args[1]);
        Euclidean_distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.print("The Euclidean distance from the point (" + x + ", " + y + ") to the origin (0, 0) is " + Euclidean_distance);
    }
}