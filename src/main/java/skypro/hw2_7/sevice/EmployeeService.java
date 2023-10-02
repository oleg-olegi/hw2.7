package skypro.hw2_7.sevice;

import java.util.Collection;

public interface EmployeeService {
    public Employee addEmployee(String name, String surname, int department);

    public Employee removeEmployee(String name, String surname);

    public Employee findEmployee(String name, String surname);

    public String printAllDepartmentsAndNames();

    public Collection getEmployeeMap();
}
