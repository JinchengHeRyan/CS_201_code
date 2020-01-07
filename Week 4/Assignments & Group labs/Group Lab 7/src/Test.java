public class Test {
    public static void testStatistics(Statistics s) {
        s.add_data_points(1);
        s.add_data_points(2);
        s.add_data_points(3);
        System.out.println("Number of data = " + s.get_num_data());
        System.out.println("Mean = " + s.get_mean());
        System.out.println("STD = " + s.get_std());
        System.out.println("Variance = " + s.get_variance());
    }

    public static void main(String[] args) {
        Statistics a = new Statistics_1();

        Statistics b = new Statistics_2();

        testStatistics(a);
        testStatistics(b);
    }
}