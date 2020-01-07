public class Problem_1_2_28 {
    public static void main(String[] args) {
        double x,y,z;
        boolean ans;
        x = Double.parseDouble(args[0]);
        y = Double.parseDouble(args[1]);
        z = Double.parseDouble(args[2]);
        if (( (x < y) && (y < z) ) || ( (x > y) && (y > z)) ) {
            ans = true;
        }
        else {
            ans = false;
        }
        System.out.println(ans);
    }
}