package GoF.Behavioral.Visitor.DepartmentSys;

public class FADepartment extends Department {
    @Override
    public void visit(FulltimeEmployee fulltimeEmployee) {
        int workTime = fulltimeEmployee.getWorkTime();
        double weeklyWage = fulltimeEmployee.getWeeklyWage();
        if (workTime > 40) {
            weeklyWage += (workTime - 40) * 100;
        } else if (workTime < 40) {
            weeklyWage -= (40 - workTime) * 80;
            if (weeklyWage < 0) {
                weeklyWage = 0;
            }
        }
        System.out.printf("正式员工%s：原始周薪为 %4.2f 元，实际周薪为 %4.2f 元\n"
                , fulltimeEmployee.getName()
                , fulltimeEmployee.getWeeklyWage()
                , weeklyWage);
    }
    @Override
    public void visit(ParttimeEmployee parttimeEmployee) {
        System.out.printf("临时工%s：时薪为 %4.2f ，时薪共为 %4.2f 元\n"
                , parttimeEmployee.getName()
                , parttimeEmployee.getHourWage()
                , parttimeEmployee.getHourWage() * parttimeEmployee.getWorkTime());
    }
}
