package GoF.Behavioral.Visitor.DepartmentSys;

public class FulltimeEmployee extends Employee { // 正式员工
    private double weeklyWage;  // 周薪
    public FulltimeEmployee(String name , int workTime , double weeklyWage) {
        super(name , workTime);
        this.weeklyWage = weeklyWage;
    }
    @Override
    public void accept(Department department) {
        department.visit(this);
    }
    public double getWeeklyWage() {
        return weeklyWage;
    }
    public void setWeeklyWage(double weeklyWage) {
        this.weeklyWage = weeklyWage;
    }
}
