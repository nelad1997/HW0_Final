import java.util.Objects;

public class Date {
    protected int day;
    protected int month;
    protected int year;

    public Date(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setDay(int day) {
        if (day <= 31 && day >= 1)
            this.day = day;
        else
            this.day = 1;
    }

    public void setMonth(int month) {
        if (month <= 12 && month >= 1)
            this.month = month;
        else
            this.month = 1;

    }

    public void setYear(int year) {
        if (year <= 9999 && year >= -9999)
            this.year = year;
        else
            this.year = 0;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Date))
            return false;
        Date d = (Date) other;
        return day == d.day && month == d.month && year == d.year;

    }

    @Override
    public String toString() {
        return day+"/"+month+"/"+"year";
    }

    @Override
    public int hashCode() {
        return ;
    }
}

