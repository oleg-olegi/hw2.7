package skypro.hw2_7.excetions;

public class EmployeeAlreadyAdded extends RuntimeException {
    public EmployeeAlreadyAdded(String message) {
        super(message);
    }
}
