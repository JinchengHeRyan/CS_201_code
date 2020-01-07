public class draft_1 {
    private static long[] f = new long[92];

    public static long fib(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (f[n] > 0) {
            return (f[n]);
        }
        f[n] = fib(n-1) + fib(n-2);
        return (f[n]);
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(fib(n));
    }
}