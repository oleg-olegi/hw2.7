package skypro.hw2_7.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.hw2_7.sevice.DepartmentServiceImpl;
import skypro.hw2_7.sevice.Employee;
import skypro.hw2_7.sevice.EmployeeServiceImpl;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    //==@Mock
    // private EmployeeServiceImpl employeeServiceMock;
    private final EmployeeServiceImpl employeeServiceMock = mock(EmployeeServiceImpl.class);
    private DepartmentServiceImpl out;

    @BeforeEach
        //==@InjectMocks
        // private DepartmentServiceImpl out;
    void initOut() {
        out = new DepartmentServiceImpl(employeeServiceMock);
    }

    @Test
    void willReturnEmployeeWithMinSalaryByDepartment() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ivan", "Dorn", 200, 1));
        employeeList.add(new Employee("Ivan", "Groznii", 300, 1));
        employeeList.add(new Employee("Ivan", "Urgant", 400, 2));

        when(employeeServiceMock.getEmployeeMap()).thenReturn(employeeList);

        Employee result = out.findMinSalaryByDepartment(1);

        assertNotNull(result);

        assertEquals(200, result.getSalary());

        Employee result1 = out.findMinSalaryByDepartment(2);

        assertNotNull(result);

        assertEquals(400, result1.getSalary());
    }

    @Test
    void testFindMinSalaryByDepartmentNoEmployee() {
        List<Employee> employeeList = new ArrayList<>();

        when(employeeServiceMock.getEmployeeMap()).thenReturn(employeeList);

        assertThrows(NoSuchElementException.class, () -> out.findMinSalaryByDepartment(1));
    }

    @Test
    void willReturnEmployeeWithMaxSalaryByDepartment() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ivan", "Dorn", 200, 1));
        employeeList.add(new Employee("Ivan", "Groznii", 300, 1));
        employeeList.add(new Employee("Ivan", "Urgant", 400, 2));

        when(employeeServiceMock.getEmployeeMap()).thenReturn(employeeList);

        Employee result = out.findMaxSalaryByDepartment(1);

        assertNotNull(result);

        assertEquals(300, result.getSalary());
    }

    @Test
    void testFindMaxSalaryByDepartmentNoEmployee() {
        List<Employee> employeeList = new ArrayList<>();

        when(employeeServiceMock.getEmployeeMap()).thenReturn(employeeList);

        assertThrows(NoSuchElementException.class, () -> out.findMaxSalaryByDepartment(1));
    }

    @Test
    void testFindSumSalaryByDepartment() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ivan", "Dorn", 200, 1));
        employeeList.add(new Employee("Ivan", "Groznii", 300, 1));
        employeeList.add(new Employee("Ivan", "Urgant", 400, 2));

        when(employeeServiceMock.getEmployeeMap()).thenReturn(employeeList);

        int result = out.getTotalSalaryCostByDepartment(1);

        assertEquals(500, result);
    }

    @Test
    void testGetAllEmployeesByDepartment() {
        int department = 1;
        Employee employee1 = new Employee("Ivan", "Dorn", 200, department);
        Employee employee2 = new Employee("Ivan", "Groznii", 300, department);

        List<Employee> employeeList = Arrays.asList(employee1, employee2);

        when(employeeServiceMock.getEmployeeMap()).thenReturn(employeeList);

        Map<Integer, List<Employee>> resultEmployeeList = out.getAllEmployeesByDepartment(1);

        assertEquals(1, resultEmployeeList.size());//проверка что у нас только один отдел
        assertEquals(employeeList, resultEmployeeList.get(department));//проверка, что список сотрудников совпадает с ожидаемым
        //очень сложно было написать тест для этого метода
    }

    @Test
    void testGetAllEmployees() {
        Employee employee1 = new Employee("Ivan", "Dorn", 200, 1);
        Employee employee2 = new Employee("Ivan", "Groznii", 300, 2);
        Employee employee3 = new Employee("Ivan", "Urgant", 400, 3);

        when(employeeServiceMock.getEmployeeMap()).thenReturn(Arrays.asList(employee1, employee2, employee3));

        List<Employee> expectedList1 = Arrays.asList(employee1);
        List<Employee> expectedList2 = Arrays.asList(employee2);
        List<Employee> expectedList3 = Arrays.asList(employee3);

        Map<Integer, List<Employee>> resultList = out.getAllEmployees();
        Map<Integer, List<Employee>> expectedResultList = Map.of(1, expectedList1, 2, expectedList2, 3, expectedList3);

        assertEquals(3, expectedResultList.size());
        assertEquals(expectedResultList, resultList);
    }
}
