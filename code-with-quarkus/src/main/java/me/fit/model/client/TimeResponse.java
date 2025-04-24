package me.fit.model.client;

public class TimeResponse {
    private float year;
    private float month;
    private float day;
    private float hour;
    private float minute;
    private float seconds;
    private float milliSeconds;
    private String dateTime;
    private String date;
    private String time;
    private String timeZone;
    private String dayOfWeek;
    private boolean dstActive;

    public TimeResponse() {
        super();
    }

    public TimeResponse(String date, String dateTime, float day, String dayOfWeek, boolean dstActive, float hour, float milliSeconds,
                        float minute, float month, float seconds, String time, String timeZone, float year) {
        this.date = date;
        this.dateTime = dateTime;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.dstActive = dstActive;
        this.hour = hour;
        this.milliSeconds = milliSeconds;
        this.minute = minute;
        this.month = month;
        this.seconds = seconds;
        this.time = time;
        this.timeZone = timeZone;
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public String getDateTime() {
        return dateTime;
    }

    public float getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isDstActive() {
        return dstActive;
    }

    public float getHour() {
        return hour;
    }

    public float getMilliSeconds() {
        return milliSeconds;
    }

    public float getMinute() {
        return minute;
    }

    public float getMonth() {
        return month;
    }

    public float getSeconds() {
        return seconds;
    }

    public String getTime() {
        return time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public float getYear() {
        return year;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setDay(float day) {
        this.day = day;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setDstActive(boolean dstActive) {
        this.dstActive = dstActive;
    }

    public void setHour(float hour) {
        this.hour = hour;
    }

    public void setMilliSeconds(float milliSeconds) {
        this.milliSeconds = milliSeconds;
    }

    public void setMinute(float minute) {
        this.minute = minute;
    }

    public void setMonth(float month) {
        this.month = month;
    }

    public void setSeconds(float seconds) {
        this.seconds = seconds;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setYear(float year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "TimeResponse{" +
                "date='" + date + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", seconds=" + seconds +
                ", milliSeconds=" + milliSeconds +
                ", dateTime='" + dateTime + '\'' +
                ", time='" + time + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", dstActive=" + dstActive +
                '}';
    }
}
