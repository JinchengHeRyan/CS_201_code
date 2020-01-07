public class Statistics_1 implements Statistics {
    private int points_num;
    private double sum;
    private double sum_square;

    public Statistics_1() {
        this.points_num = 0;
        this.sum = 0;
        this.sum_square = 0;
    }

    public void add_data_points(double a) {
        this.points_num += 1;
        this.sum += a;
        this.sum_square += a * a;
    }

    public int get_num_data() {
        return this.points_num;
    }

    public double get_mean() {
        return (this.sum / this.points_num);
    }

    public double get_std() {
        double ans;
        ans = Math.sqrt((this.sum_square - 2 * this.get_mean() * this.sum)/this.points_num + this.get_mean() * this.get_mean());
        return ans;
    }

    public double get_variance() {
        double ans;
        ans = (this.sum_square / this.points_num) - (this.get_mean() * this.get_mean());
        return ans;
    }
}