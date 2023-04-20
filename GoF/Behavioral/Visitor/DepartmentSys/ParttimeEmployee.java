package GoF.Behavioral.Visitor.DepartmentSys;

public class ParttimeEmployee extends Employee {  // 临时工
    private double hourWage;  // 时薪
    public ParttimeEmployee(String name, int workTime , double hourWage) {
        super(name, workTime);
        this.hourWage = hourWage;
    }
    @Override
    public void accept(Department department) {
        department.visit(this);
    }
    public double getHourWage() {
        return hourWage;
    }
    public void setHourWage(double hourWage) {
        this.hourWage = hourWage;
    }
}
