public class Problem_1_2_17 {
    public static void main(String[] args) {
        // int a = 1;     (a = 1)
        // a = a + a;     (a = 2)
        // a = a + a;     (a = 4)
        // a = a + a;     (a = 8)
        // Let's see whether our answers are correct:
        int a = 1;
        System.out.println("a = " + a);
        a = a + a;
        System.out.println("a = " + a);
        a = a + a;
        System.out.println("a = " + a);
        a = a + a;
        System.out.println("a = " + a);
        // Correct !

        // boolean a = true;    (a = true)
        // a = !a;              (a = false)
        // a = !a;              (a = true)
        // a = !a;              (a = false)
        // Let's see whether our answers are correct:
        // Since "a" has already been defined, we will use variable "b" instead
        boolean b = true;
        System.out.println("b = " + b);

        b = !b;
        System.out.println("b = " + b);

        b = !b;
        System.out.println("b = " + b);

        b = !b;
        System.out.println("b = " + b);
        // Correct!

        // int a = 2;    (a = 2)
        // a = a * a;    (a = 4)
        // a = a * a;    (a = 16)
        // a = a * a;    (a = 256)
        // Let's see whether our answers are correct:
        // Since "a" and "b" has already been defined, we will use variable "c" instead
        int c = 2;
        System.out.println("c = " + c);

        c = c * c;
        System.out.println("c = " + c);

        c = c * c;
        System.out.println("c = " + c);

        c = c * c;
        System.out.println("c = " + c);
        // Correct!

    }
}