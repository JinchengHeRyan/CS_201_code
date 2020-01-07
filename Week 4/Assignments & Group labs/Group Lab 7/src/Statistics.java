public interface Statistics {
    public void add_data_points(double a);
    public int get_num_data();
    public double get_mean();
    public double get_variance();
    public double get_std();
}