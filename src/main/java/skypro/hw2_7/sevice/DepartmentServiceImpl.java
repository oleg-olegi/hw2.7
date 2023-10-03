package skypro.hw2_7.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Employee findMinSalaryByDepartment(int numberOfDepartment) {
        return employeeServiceImpl.getEmployeeMap().stream()
                .filter(a -> a.getDepartment() == numberOfDepartment)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()-> new NoSuchElementException("Employee not found"));
    }

    @Override
    public Employee findMaxSalaryByDepartment(int numberOfDepartment) {
        return null;
    }

    @Override
    public Employee getTotalSalaryCostByDepartment(int department) {
        return null;
    }

    @Override
    public Employee getAverageSalaryCostByDepartment(int department) {
        return null;
    }

    @Override
    public Employee indexSalaryCostByDepartment(int department, int percent) {
        return null;
    }

    @Override
    public Employee printEmployeesInDepartment(int department) {
        return null;
    }

    //нати сотрудника с мин ЗП по номеру отдела
   /* public void findMinSalaryByDepartment(int numberOfDepartment) {
        Employee employee = null;
        int min = Integer.MAX_VALUE;
        for (Employee a : employees)

            if (a != null && a.getDepartment() == numberOfDepartment && a.getSalary() < min) {
                min = a.getSalary();
                employee = a;
            }
        System.out.println("Минимальная ЗП по отделу " + numberOfDepartment + "\n- " + employee);
        System.out.println("====================================");
    }

    //нати сотрудника с max ЗП по номеру отдела
    public void findMaxSalaryByDepartment(int numberOfDepartment) {
        Employee employee = null;
        int max = -1;
        for (Employee o : employees) {

            if (o != null && o.getDepartment() == numberOfDepartment && o.getSalary() > max) {
                max = o.getSalary();
                employee = o;

            }
        }
        System.out.println("Максимальная ЗП по отделу " + numberOfDepartment + "\n- " + employee);
        System.out.println("====================================");
    }

    //сумма затрат на ЗП по отделу
    public void getTotalSalaryCostByDepartment(int department) {
        int totalCost = 0;
        for (Employee o : employees) {
            if (o != null && o.getDepartment() == department) {
                totalCost += o.getSalary();
            }
        }
        System.out.println("Суммарная ЗП по отделу " + department + " - " + totalCost);
        System.out.println("====================================");
    }

    //средняя ЗП по отделу
    public void getAverageSalaryCostByDepartment(int department) {
        int averageCost = 0;
        int count = 0;
        for (Employee o : employees) {

            if (o != null && o.getDepartment() == department) {
                averageCost += o.getSalary();
                count++;
            }
        }
        averageCost = averageCost / count;
        System.out.println("Средняя ЗП по отделу " + department + " - " + averageCost);
    }

    //индексация ЗП сотрудников одного отдела
    public void indexSalaryCostByDepartment(int department, int percent) {
        for (Employee o : employees) {

            if (o != null && o.getDepartment() == department) {
                int currentSalary = o.getSalary();
                int indexSalary = currentSalary + (currentSalary / 100 * percent);
                o.setSalary(indexSalary);
            }
        }
    }

    //напечатать всех сотрудников отдела - все данные, кроме отдела
    public void printEmployeesInDepartment(int department) {
        for (Employee o : employees) {
            if (o.getDepartment() == department) {
                System.out.println(o.getName() + " " + o.getSalary() + " " + o.getId() + "\n=======================================");
            }
        }
    }*/
}
