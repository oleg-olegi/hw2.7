package skypro.hw2_7.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.hw2_7.sevice.DepartmentServiceImpl;
import skypro.hw2_7.sevice.Employee;
import skypro.hw2_7.sevice.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
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
    }
    @Test
    void testFindMinSalaryByDepartmentNoEmployee() {
        List<Employee> employeeList = new ArrayList<>();

        when(employeeServiceMock.getEmployeeMap()).thenReturn(employeeList);

        assertThrows(NoSuchElementException.class, () -> out.findMaxSalaryByDepartment(1));
    }

}
