public class Problem_1_2_3 {
    public static void main(String[] args) {
        boolean a,b,answer;
        a = true; b = true;
        answer = (!(a && b) && (a || b)) || ((a && b) || !(a || b));
        System.out.println(answer);

        a = true; b = false;
        answer = (!(a && b) && (a || b)) || ((a && b) || !(a || b));
        System.out.println(answer);

        a = false; b = true;
        answer = (!(a && b) && (a || b)) || ((a && b) || !(a || b));
        System.out.println(answer);

        a = false; b = false;
        answer = (!(a && b) && (a || b)) || ((a && b) || !(a || b));
        System.out.println(answer);
    }
}