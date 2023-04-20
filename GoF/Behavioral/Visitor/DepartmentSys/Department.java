package GoF.Behavioral.Visitor.DepartmentSys;

public abstract class Department {
    public abstract void visit(FulltimeEmployee fulltimeEmployee);   // 一系列重载方法
    public abstract void visit(ParttimeEmployee parttimeEmployee);
}
