package skypro.hw2_7.sevice;

public interface EmployeeService {
    public Employee addEmployee(String name, String surname, int department);

    public Employee removeEmployee(String name, String surname);

    public Employee findEmployee(String name, String surname);

    public void printAllDepartmentsAndNames();
}
