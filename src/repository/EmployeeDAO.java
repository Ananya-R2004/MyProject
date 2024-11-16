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

            pstmt.setInt(1, employee.getEmployeeId());  // employee_id (unique ID assigned by your application)
            pstmt.setString(2, employee.getName());    // name
            pstmt.setString(3, employee.getPosition());    // position
            pstmt.setDouble(4, employee.getSalary());   // salary
            pstmt.setInt(5, employee.getAge());        // age
            pstmt.setInt(6, employee.getDepartmentId()); // department_id (foreign key)
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
                        rs.getInt("id"),                     // Primary Key ID
                        rs.getInt("employee_id"),            // Employee ID
                        rs.getString("name"),                // Name
                        rs.getString("position"),            // Position
                        rs.getDouble("salary"),              // Salary
                        rs.getInt("age"),                    // Age
                        rs.getInt("department_id")           // Department ID
                );
                employee.setDepartmentName(rs.getString("department_name")); // Optional field
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

            pstmt.setString(1, employee.getName());      // Update Name
            pstmt.setString(2, employee.getPosition());  // Update Position
            pstmt.setDouble(3, employee.getSalary());    // Update Salary
            pstmt.setInt(4, employee.getAge());          // Update Age
            pstmt.setInt(5, employee.getDepartmentId()); // Update Department ID
            pstmt.setInt(6, employee.getId());           // Update based on Primary Key ID
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

            pstmt.setInt(1, employeeId); // Delete based on Employee ID
            pstmt.executeUpdate();
            System.out.println("Employee deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }
}
