public class Problem_1_2_30 {
    public static void main(String[] args) {
        double ave, min_num = 1.0, max_num = 0, sum = 0;
        double a[];
        int n = 5;
        a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = Math.random();
            sum += a[i];
            if (a[i] < min_num) {
                min_num = a[i];
            }
            if (a[i] > max_num) {
                max_num = a[i];
            }
        }
        ave = sum / a.length;

        System.out.println("a = " + a[0]);
        System.out.println("b = " + a[1]);
        System.out.println("c = " + a[2]);
        System.out.println("d = " + a[3]);
        System.out.println("e = " + a[4]);
        System.out.println("Average = " + ave);
        System.out.println("Maximum = " + max_num);
        System.out.println("Minimum = " + min_num);
    }
}