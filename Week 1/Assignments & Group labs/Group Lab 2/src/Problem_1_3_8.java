public class Problem_1_3_8 {
    public static void main(String[] args) {
        for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
            if (i % 10 == 1) {
                if (i % 100 == 11) {
                    System.out.println(i + "th Hello");
                }
                else {
                    System.out.println(i + "st Hello");
                }
            }
            else if (i % 10 == 2) {
                if (i % 100 == 12) {
                    System.out.println(i + "th Hello");
                }
                else {
                    System.out.println(i + "nd Hello");
                }
            }
            else if (i % 10 == 3) {
                if (i % 100 == 13) {
                    System.out.println(i + "th Hello");
                }
                else {
                    System.out.println(i + "rd Hello");
                }
            }
            else {
                System.out.println(i + "th Hello");
            }
        }
    }
}