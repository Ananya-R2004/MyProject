package repository;

import util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Employee;

public class EmployeeDAO {

    // Create (Insert) an Employee
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (employee_id, name, position, salary, age, department_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employee.getEmployeeId());
            pstmt.setString(2, employee.getName());
            pstmt.setString(3, employee.getPosition());
            pstmt.setDouble(4, employee.getSalary());
            pstmt.setInt(5, employee.getAge());
            pstmt.setInt(6, employee.getDepartmentId());
            pstmt.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    // Read (Retrieve) all Employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = """
            SELECT e.id, e.employee_id, e.name, e.position, e.salary, e.age, e.department_id, d.name AS department_name 
            FROM employees e
            LEFT JOIN departments d ON e.department_id = d.department_id
            """;

        try (Connection conn = DatabaseUtil.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getInt("employee_id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getInt("age"),
                        rs.getInt("department_id")
                );
                employee.setDepartmentName(rs.getString("department_name"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving employees: " + e.getMessage());
        }
        return employees;
    }

    // Update an Employee
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, position = ?, salary = ?, age = ?, department_id = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setDouble(3, employee.getSalary());
            pstmt.setInt(4, employee.getAge());
            pstmt.setInt(5, employee.getDepartmentId());
            pstmt.setInt(6, employee.getId());
            pstmt.executeUpdate();
            System.out.println("Employee updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    // Delete an Employee
    public void deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        try (Connection conn = DatabaseUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            pstmt.executeUpdate();
            System.out.println("Employee deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}
