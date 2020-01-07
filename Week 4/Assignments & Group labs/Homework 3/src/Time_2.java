import java.util.Date;

public class Time_2 {
    private Date date = new Date();
    public final int all_seconds;

    public Time_2() {
        this.all_seconds = date.getHours() * 60 * 60 + date.getMinutes() * 60 + date.getSeconds();
    }

    public int get_hour() {
        return this.all_seconds/3600;
    }

    public int get_minute() {
        return ((this.all_seconds - this.get_hour() * 3600) / 60);
    }

    public int get_second() {
        return (this.all_seconds - this.get_hour() * 3600 - this.get_minute() * 60);
    }

    public String toString() {
        return this.all_seconds + " seconds from midnight";
    }

    public boolean equals(Object x) {
        if (x.getClass() == Time_1.class) {
            Time_1 t = (Time_1) x;
            return (t.get_hour() * 60 * 60 + t.get_minute() * 60 + t.get_second() == this.all_seconds);
        }
        if (x.getClass() == Time_2.class) {
            Time_2 t = (Time_2) x;
            return (t.all_seconds == this.all_seconds);
        }
        return false;
    }
}