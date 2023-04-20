package GoF.Behavioral.Visitor.DepartmentSys;

public class HRDepartment extends Department {
    @Override
    public void visit(FulltimeEmployee fulltimeEmployee) {
        int workTime = fulltimeEmployee.getWorkTime();
        System.out.printf("正式员工%s：实际工作时间为 %2d 小时，加班 %2d 小时，请假 %2d 小时\n"
                , fulltimeEmployee.getName()
                , workTime
                , Math.max((workTime - 40), 0)
                , Math.max((40 - workTime) , 0));
    }
    @Override
    public void visit(ParttimeEmployee parttimeEmployee) {
        System.out.printf("临时工%s：实际工作实际为 %2d 小时\n"
                , parttimeEmployee.getName()
                , parttimeEmployee.getWorkTime());
    }
}
