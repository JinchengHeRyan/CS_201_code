public class Problem_3_1_17 {
    public static void main(String[] args) {
        String s = args[0];
        String[] s_split = s.split("\\.");
        String ans = "";
        for (int i = s_split.length - 1; i >= 0; i--) {
            ans += s_split[i];
            if (i != 0) {
                ans += ".";
            }
        }
        System.out.println("The reverse domain name is: " + ans);
    }
}