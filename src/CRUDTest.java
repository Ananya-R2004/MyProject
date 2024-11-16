import models.Employee;
import repository.EmployeeDAO;

public class CRUDTest {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Create (Add a new employee)
        Employee newEmployee = new Employee(0, 1, "John Doe", "Developer", 50000.0, 30, 1);
        employeeDAO.addEmployee(newEmployee);

        // Read (Get all employees)
        System.out.println("All Employees:");
        employeeDAO.getAllEmployees().forEach(System.out::println);

        // Update (Change the name of the employee)
        newEmployee.setName("Jane Doe");
        employeeDAO.updateEmployee(newEmployee);

        // Read (Get updated employee information)
        System.out.println("Updated Employees:");
        employeeDAO.getAllEmployees().forEach(System.out::println);

        // Delete (Delete the employee)
        employeeDAO.deleteEmployee(newEmployee.getEmployeeId());

        // Read (Confirm deletion by fetching all employees)
        System.out.println("Employees after Deletion:");
        employeeDAO.getAllEmployees().forEach(System.out::println);
    }
}
