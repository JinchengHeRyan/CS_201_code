import java.util.Date;

public class Time_1 {
    private Date date = new Date();
    
    public final int hours, minutes, seconds;
    public Time_1() {
        this.hours = date.getHours();
        this.minutes = date.getMinutes();
        this.seconds = date.getSeconds();
    }

    public int get_hour() {
        return this.hours;
    }

    public int get_minute() {
        return this.minutes;
    }

    public int get_second() {
        return this.seconds;
    }

    public String toString() {
        return this.get_hour() + ":" + this.get_minute() + ":" + this.get_second();
    }

    public boolean equals(Object x) {
        if (x.getClass() == Time_2.class) {
            Time_2 t = (Time_2) x;
            return (t.all_seconds == this.get_hour() * 60 * 60 + this.get_minute() * 60 + this.get_second());
        }
        if (x.getClass() == Time_1.class) {
            Time_1 t = (Time_1) x;
            return (t.get_hour() == this.get_hour() && t.get_minute() == this.get_minute() && t.get_second() == this.get_second());
        }
        return false;
    }
}