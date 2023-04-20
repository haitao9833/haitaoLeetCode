package GoF.Creational.Prototype;

import java.io.Serializable;

public class MonthlyLog extends Log implements Cloneable , Serializable {

    private WeeklyLog weeklyLog;

    public void setWeeklyLog(WeeklyLog weeklyLog) {
        this.weeklyLog = weeklyLog;
    }
    public WeeklyLog getWeeklyLog() {
        return weeklyLog;
    }

    @Override
    public MonthlyLog clone() {
        try {
            return (MonthlyLog) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
