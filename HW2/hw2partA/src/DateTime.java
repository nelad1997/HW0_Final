import java.util.Objects;

public class DateTime extends Date {
    private int hour;
    private int minute;

    public DateTime(int day, int month, int year, int hour, int minute) {
        super(day, month, year);
        this.hour = hour;
        this.minute = minute;

    }

    public void setHour(int hour) {
        if (hour <= 23 && hour >= 0)
            this.hour = hour;
        else
            this.hour = 0;
    }

    public void setMinute(int minute) {
        if (minute <= 59 && minute >= 0)
            this.minute = minute;
        else
            this.minute = 0;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DateTime))
            return false;
        DateTime dt = (DateTime) other;
        return day == dt.day && month == dt.month && year == dt.year && hour==dt.hour && minute==dt.minute;
    }

    @Override
    public String toString() {
        return super.toString()+" "+hour+":"+minute;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
