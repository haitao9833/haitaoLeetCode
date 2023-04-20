package GoF.Behavioral.Visitor.DepartmentSys;

public abstract class Employee {
    protected String name;   // 员工姓名
    protected int workTime;  // 工作时间
    public Employee(String name, int workTime) {
        this.name = name;
        this.workTime = workTime;
    }
    public abstract void accept(Department department);
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWorkTime() {
        return workTime;
    }
    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }
}
