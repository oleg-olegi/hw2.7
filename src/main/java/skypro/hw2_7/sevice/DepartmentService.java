package skypro.hw2_7.sevice;

import java.util.Collection;

public interface DepartmentService {
    //нати сотрудника с мин ЗП по номеру отдела
    public Employee findMinSalaryByDepartment(int numberOfDepartment);

    //нати сотрудника с max ЗП по номеру отдела
    public Employee findMaxSalaryByDepartment(int numberOfDepartment);

    //сумма затрат на ЗП по отделу
    public int getTotalSalaryCostByDepartment(int department);

    //все сотрудники по отделу
    public Collection<Employee> getAllEmployeesByDepartment(int department);

    //все сотрудники вцелом
    public Collection<Employee> getAllEmployees();
}
