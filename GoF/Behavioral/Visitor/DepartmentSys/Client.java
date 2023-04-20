package GoF.Behavioral.Visitor.DepartmentSys;

import GoF.Behavioral.XMLUtil;

/**
 * 访问者
 */

public class Client {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        employeeList.addEmployee(new FulltimeEmployee("XXX" , 45 , 3200));
        employeeList.addEmployee(new FulltimeEmployee("ZZZ" , 38 , 2400));
        employeeList.addEmployee(new FulltimeEmployee("YYY" , 40 , 2000));
        employeeList.addEmployee(new ParttimeEmployee("aaa" , 20 , 80));
        employeeList.addEmployee(new ParttimeEmployee("bbb" , 12 , 100));
        for (Department department : XMLUtil.getVisitorBeans()) {
            employeeList.accept(department);
            System.out.println("-----");
        }
    }
}
