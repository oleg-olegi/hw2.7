package skypro.hw2_7.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro.hw2_7.exceptions.EmployeeAlreadyAddedException;
import skypro.hw2_7.exceptions.MaximumEmployeesException;
import skypro.hw2_7.sevice.Employee;
import skypro.hw2_7.sevice.EmployeeServiceImpl;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setEmployeeService() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    void testAddEmployee() {
        String name = "Klava";
        String surname = "Koka";
        int salary = 1000;
        int department = 1;
        Employee addedEmployee = employeeService.addEmployee(name, surname, salary, department);
        assertNotNull(addedEmployee);
        assertEquals(name, addedEmployee.getName());
        assertEquals(surname, addedEmployee.getSurname());
        assertEquals(salary, addedEmployee.getSalary());
        assertEquals(department, addedEmployee.getDepartment());

        //проверка, что сотрудник действительно добавлен в коллекцию
        Collection<Employee> collections = employeeService.getEmployeeMap();
        assertTrue(collections.contains(addedEmployee));
    }

    @Test
    void testAddDuplicateEmployee() {
        String name = "Klava";
        String surname = "Koka";
        int salary = 1000;
        int department = 1;
        //первый вызов метода
        Employee addedEmployee = employeeService.addEmployee(name, surname, salary, department);
        //второй вызов метода с теми же данными
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.addEmployee(name, surname, salary, department));
    }

    @Test
    void testAddMaxEmployees() {
        for (int i = 0; i < EmployeeServiceImpl.MAX_EMPLOYEES; i++) {
            String name = "Klava" + ((char)(97+i));
            String surname = "Koka" + ((char)(97+i));
            int salary = 1000 + i;
            int department = 1 + i;
//добавляем максимальное количество сотрудников
            employeeService.addEmployee(name, surname, salary, department);
//добавляем еще одного сотрудника
                    }
        assertThrows(MaximumEmployeesException.class, () ->
                employeeService.addEmployee("Fiodor", "Koniuhov", 2, 1));
    }
}
