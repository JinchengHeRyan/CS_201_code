public class Problem_1_2_32 {
    public static void main(String[] args) {
        double r, g, b, w, c, m, y, k;
        r = Double.parseDouble(args[0]);
        g = Double.parseDouble(args[1]);
        b = Double.parseDouble(args[2]);
        if ((int) r == 0 && (int) g == 0 && (int) b == 0) {
            c = 0; m = 0; y = 0; k = 1;
        }
        else {
            w = Math.max(Math.max(r/255, g/255), b/255);
            c = (w - (r/255)) / w;
            m = (w - (g/255)) / w;
            y = (w - (b/255)) / w;
            k = 1-w;
        }

        System.out.println("c = " + c);
        System.out.println("m = " + m);
        System.out.println("y = " + y);
        System.out.println("k = " + k);
    }
}