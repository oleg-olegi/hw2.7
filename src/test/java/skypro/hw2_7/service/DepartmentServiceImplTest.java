package skypro.hw2_7.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.hw2_7.sevice.DepartmentServiceImpl;
import skypro.hw2_7.sevice.EmployeeServiceImpl;

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

}
