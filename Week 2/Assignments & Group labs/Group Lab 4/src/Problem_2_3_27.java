public class Problem_2_3_27 {
    public static void drawtri(double x, double y, double size) {
        double x0 = x - size/2;
        double x1 = x + size/2;
        double x2 = x;
        double y0 = y - size / (2*Math.sqrt(3));
        double y1 = y - size / (2*Math.sqrt(3));
        double y2 = y + size/Math.sqrt(3);
        StdDraw.line(x0, y0, x1, y1);
        StdDraw.line(x2, y2, x1, y1);
        StdDraw.line(x0, y0, x2, y2);
    }

    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;
        // if (n == 1) {
        //     drawtri(x, y, -size);
        // }
        
        drawtri(x, y, -size);

        double x0 = x - size/2;
        double x1 = x + size/2;
        double x2 = x;
        double y0 = y - size / (2 * Math.sqrt(3));
        double y1 = y - size / (2 * Math.sqrt(3));
        double y2 = y + size / (Math.sqrt(3));

        draw(n-1, x0, y0, size/2);
        draw(n-1, x1, y1, size/2);
        draw(n-1, x2, y2, size/2);
    
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double x = 0.5, y = 0.5;
        double size = 0.5;
        if (n == 1) {
            drawtri(x, y, size);
        }

        else {
            drawtri(x, y, size);
            draw(n-1, x, y, size/2);
        }
    }
}