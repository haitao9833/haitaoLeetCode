package GoF.Creational.Prototype;

/**
 * 原型模式
 *        抽象原型      声明公共的克隆方法
 *        具体原型      实现各自特定的克隆方法，有共同的父类
 *        原型工厂      储存多个具体原型实例，调用克隆方法返回克隆原型，封装克隆过程，一般设计为单例类，以节省系统资源
 *        应用：复制、粘贴、保存对象历史状态以复用、恢复
 *        缺点：对象内部嵌套对象较深时，想要实现深克隆，需要每一层都支持深克隆或者序列化 implements Serializable
 */

public class Client {
    public static void main(String[] args) {
        useManager();
    }

    private static void useManager() {
        MonthlyLog monthlyLog = new MonthlyLog();
        monthlyLog.setName("月报");
        monthlyLog.setWeeklyLog(new WeeklyLog());
        monthlyLog.getWeeklyLog().setName("月中周报");
        monthlyLog.getWeeklyLog().setAttachment(new Attachment());
        monthlyLog.getWeeklyLog().getAttachment().setName("月附件");

        System.out.println(LogPrototypeManager.size());
        LogPrototypeManager.add("monthlyLog01" , monthlyLog);
        System.out.println(LogPrototypeManager.size());

        MonthlyLog monthlyLog_clone = (MonthlyLog) LogPrototypeManager.get("monthlyLog01");
        System.out.println(monthlyLog == monthlyLog_clone);
        System.out.println(monthlyLog.getWeeklyLog() == monthlyLog_clone.getWeeklyLog());
        System.out.println(monthlyLog.getWeeklyLog().getAttachment() == monthlyLog_clone.getWeeklyLog().getAttachment());

        // 字符串 name
        System.out.println(monthlyLog.getWeeklyLog().getAttachment().getName() == monthlyLog_clone.getWeeklyLog().getAttachment().getName());
        System.out.println(monthlyLog.getWeeklyLog().getAttachment().getName().equals(monthlyLog_clone.getWeeklyLog().getAttachment().getName()));
    }

    private static void shallowOrDeep() {
        WeeklyLog weeklyLog = new WeeklyLog();
        weeklyLog.setAttachment(new Attachment());

        WeeklyLog weeklyLog_clone = weeklyLog.clone(); // 浅克隆
        System.out.println(weeklyLog == weeklyLog_clone);
        System.out.println(weeklyLog.getAttachment() == weeklyLog_clone.getAttachment());

        System.out.println();

        WeeklyLog weeklyLog_deep_clone = weeklyLog.deepClone(); // 深克隆
        System.out.println(weeklyLog == weeklyLog_deep_clone);
        System.out.println(weeklyLog.getAttachment() == weeklyLog_deep_clone.getAttachment());

        System.out.println("\n-----\n");

        MonthlyLog monthlyLog = new MonthlyLog();
        monthlyLog.setWeeklyLog(new WeeklyLog());
        monthlyLog.getWeeklyLog().setAttachment(new Attachment());

        MonthlyLog monthlyLog_clone = monthlyLog.clone(); // 浅克隆
        System.out.println(monthlyLog == monthlyLog_clone);
        System.out.println(monthlyLog.getWeeklyLog() == monthlyLog_clone.getWeeklyLog());
        System.out.println(monthlyLog.getWeeklyLog().getAttachment() == monthlyLog_clone.getWeeklyLog().getAttachment());

        System.out.println();

        MonthlyLog monthlyLog_deep_clone = monthlyLog.deepClone(); // 深克隆
        System.out.println(monthlyLog == monthlyLog_deep_clone);
        System.out.println(monthlyLog.getWeeklyLog() == monthlyLog_deep_clone.getWeeklyLog());
        System.out.println(monthlyLog.getWeeklyLog().getAttachment() == monthlyLog_deep_clone.getWeeklyLog().getAttachment());
    }
}
