package skypro.hw2_7.controller;

import org.springframework.web.bind.annotation.*;
import skypro.hw2_7.sevice.DepartmentService;
import skypro.hw2_7.sevice.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees") // возвращаем всех сотрудников отдела дз 2.13
    public Map<Integer, List<Employee>> getAllEmployeesByDepartmentWithPathVariable(@PathVariable int id) {
        return departmentService.getAllEmployeesByDepartment(id);
    }


    @GetMapping("/{id}/salary/sum") //выводит сумму зп по отделу
    public int sumSalaryByDepartment(@PathVariable int id) {
        return departmentService.getTotalSalaryCostByDepartment(id);
    }

    @GetMapping("/{id}/salary/max") //возвращает максимальную зарплату по отделу
    public Employee maxSalary(@PathVariable int id) {
        return departmentService.findMaxSalaryByDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public Employee minSalary(@PathVariable int id) {
        return departmentService.findMinSalaryByDepartment(id);
    }

    @GetMapping("employees") //возвращаем список всех сотрудников
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAllEmployees();
    }
    /*  @GetMapping(path = "/max-salary")
      public Employee maxSalary(@RequestParam int departmentID) {
          return departmentService.findMaxSalaryByDepartment(departmentID);
      }

    @GetMapping(path = "/sum-salary") //выводит сумму зп по отделу
     public int sumSalaryByDepartment(@RequestParam int departmentID) {
         return departmentService.getTotalSalaryCostByDepartment(departmentID);
     }

 @GetMapping(path = "/all", params = "departmentID") // возвращаем всех сотрудников отдела
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment(@RequestParam int departmentID) {
        return departmentService.getAllEmployeesByDepartment(departmentID);
    }
  @GetMapping(path = "/min-salary")
      public Employee minSalary(@RequestParam int departmentID) {
          return departmentService.findMinSalaryByDepartment(departmentID);
      } */
}
