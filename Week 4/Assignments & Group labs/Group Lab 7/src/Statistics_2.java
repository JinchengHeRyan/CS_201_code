public class Statistics_2 implements Statistics {
    private double[] data_array;
    private int points_num;

    public Statistics_2() {
        this.data_array = new double[100];
        this.points_num = 0;
    }

    public void add_data_points(double a) {
        this.data_array[this.points_num] = a;
        this.points_num += 1;
    }

    public double get_sum() {
        double ans = 0;
        for (int i = 0; i < this.points_num; i++) {
            ans += this.data_array[i];
        }
        return ans;
    }

    public double get_sum_square() {
        double ans = 0;
        for (int i = 0; i < this.points_num; i++) {
            ans += this.data_array[i] * this.data_array[i];
        }
        return ans;
    }

    public int get_num_data() {
        return this.points_num;
    }

    public double get_mean() {
        return (this.get_sum() / this.get_num_data());
    }

    public double get_variance() {
        double ans;
        ans = this.get_sum_square() / this.get_num_data() - this.get_mean() * this.get_mean();
        return ans;
    }

    public double get_std() {
        return Math.sqrt(this.get_variance());
    }
}