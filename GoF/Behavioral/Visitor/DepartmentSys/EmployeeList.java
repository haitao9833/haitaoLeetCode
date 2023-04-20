package GoF.Behavioral.Visitor.DepartmentSys;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private List<Employee> list = new ArrayList<>();
    public void addEmployee(Employee employee) {
        list.add(employee);
    }
    public void accept(Department department) {
        for (Employee employee : list) {
            employee.accept(department);
        }
    }
}
