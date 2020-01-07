public class Problem_1_2_5 {
    public static void main(String[] args) {
        boolean a, b;
        a = true ; b = true;
        System.out.print("true ^ true = ");
        System.out.println(a ^ b);

        a = true ; b = false;
        System.out.print("true ^ false = ");
        System.out.println(a ^ b);

        a = false ; b = true;
        System.out.print("false ^ true = ");
        System.out.println(a ^ b);

        a = false ; b = false;
        System.out.print("false ^ false = ");
        System.out.println(a ^ b);
    }
}