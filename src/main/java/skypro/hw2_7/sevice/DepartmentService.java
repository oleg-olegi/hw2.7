package skypro.hw2_7.sevice;

import java.util.Optional;

public interface DepartmentService {
    //нати сотрудника с мин ЗП по номеру отдела
    public Employee findMinSalaryByDepartment(int numberOfDepartment);

    //нати сотрудника с max ЗП по номеру отдела
    public Employee findMaxSalaryByDepartment(int numberOfDepartment);

    //сумма затрат на ЗП по отделу
    public Employee getTotalSalaryCostByDepartment(int department);

    //средняя ЗП по отделу
    public Employee getAverageSalaryCostByDepartment(int department);

    //индексация ЗП сотрудников одного отдела
    public Employee indexSalaryCostByDepartment(int department, int percent);

    //напечатать всех сотрудников отдела - все данные, кроме отдела
    public Employee printEmployeesInDepartment(int department);


}
