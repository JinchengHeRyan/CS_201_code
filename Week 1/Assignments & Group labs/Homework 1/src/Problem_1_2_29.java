public class Problem_1_2_29 {
    public static void main(String[] args) {
        int m,d,y,y_0,x,m_0,d_0;
        m = Integer.parseInt(args[0]);
        d = Integer.parseInt(args[1]);
        y = Integer.parseInt(args[2]);

        y_0 = y - ( (14 - m) / 12);
        x = y_0 + y_0/4 - y_0/100 + y_0/400;
        m_0 = m + 12*((14 - m) / 12) - 2;
        d_0 = (d + x + (31 * m_0) / 12) % 7;
        System.out.println(d_0);
    }
}