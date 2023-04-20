package GoF.Creational.Prototype;

import java.util.HashMap;

public class LogPrototypeManager {
    private static HashMap<String , Log> prototypes = new HashMap<>(){
        {
            WeeklyLog weeklyLog = new WeeklyLog();
            weeklyLog.setAttachment(new Attachment());
            put("weeklyLog" , weeklyLog);

            MonthlyLog monthlyLog = new MonthlyLog();
            monthlyLog.setWeeklyLog(new WeeklyLog());
            monthlyLog.getWeeklyLog().setAttachment(new Attachment());
            put("monthlyLog" , monthlyLog);
        }
    };
    public static int size() {
        return prototypes.size();
    }
    public static void add(String key , Log log) {
        prototypes.put(key , log);
    }
    public static Log get(String key) {
        return prototypes.get(key).deepClone();  // 深克隆
    }
}
