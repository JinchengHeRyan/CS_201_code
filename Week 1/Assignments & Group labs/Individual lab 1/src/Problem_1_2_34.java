public class Problem_1_2_34 {
    public static void main(String[] args) {
        int x,y,z,temp_min, temp_max;
        x = Integer.parseInt(args[0]);
        y = Integer.parseInt(args[1]);
        z = Integer.parseInt(args[2]);
        temp_min = Math.min(x,y);
        temp_max = Math.max(x,y);
        x = temp_min;
        y = temp_max;

        temp_min = Math.min(x,z);
        temp_max = Math.max(x,z);
        x = temp_min;
        z = temp_max;

        temp_min = Math.min(y,z);
        temp_max = Math.max(y,z);
        y = temp_min;
        z = temp_max;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}