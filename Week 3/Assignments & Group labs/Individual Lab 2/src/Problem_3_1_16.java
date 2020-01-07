public class Problem_3_1_16 {
    public static void main(String[] args) {
        String s = args[0];
        int last_dot = s.lastIndexOf(".");
        String top_level = s.substring(last_dot+1, s.length());
        System.out.println("Top-level domain is: " + top_level);
    }
}