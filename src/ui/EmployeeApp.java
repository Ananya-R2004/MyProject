package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.Employee;
import repository.EmployeeDAO;

public class EmployeeApp extends Application {

    EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Performance Analysis");

        // Create UI Components
        Label labelName = new Label("Name:");
        TextField nameField = new TextField();

        Label labelPosition = new Label("Position:");
        TextField positionField = new TextField();

        Label labelSalary = new Label("Salary:");
        TextField salaryField = new TextField();

        Label labelAge = new Label("Age:");
        TextField ageField = new TextField();

        Label labelDepartment = new Label("Department ID:");
        TextField departmentField = new TextField();

        Button addButton = new Button("Add Employee");
        Button updateButton = new Button("Update Employee");
        Button viewButton = new Button("View All Employees");

        // Layout Setup
        VBox layout = new VBox(10, 
            labelName, nameField, 
            labelPosition, positionField, 
            labelSalary, salaryField, 
            labelAge, ageField, 
            labelDepartment, departmentField, 
            addButton, updateButton, viewButton
        );
        layout.setStyle("-fx-padding: 10; -fx-background-color: #f4f4f4;");

        // Add Employee functionality
        addButton.setOnAction(_ -> { // Changed 'e' to '_'
            try {
                String name = nameField.getText();
                String position = positionField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                int age = Integer.parseInt(ageField.getText());
                int departmentId = Integer.parseInt(departmentField.getText());

                Employee newEmployee = new Employee(0, name, position, salary, age, departmentId);
                employeeDAO.addEmployee(newEmployee);
                System.out.println("Employee added successfully!");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            }
        });

        // Update Employee functionality
        updateButton.setOnAction(_ -> { // Changed 'e' to '_'
            try {
                int employeeId = Integer.parseInt(departmentField.getText()); // Replace with actual employee selection
                String name = nameField.getText();
                String position = positionField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                int age = Integer.parseInt(ageField.getText());
                int departmentId = Integer.parseInt(departmentField.getText());

                Employee employeeToUpdate = new Employee(employeeId, name, position, salary, age, departmentId);
                employeeDAO.updateEmployee(employeeToUpdate);
                System.out.println("Employee updated successfully!");
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
            }
        });

        // View all Employees
        viewButton.setOnAction(_ -> { // Changed 'e' to '_'
            System.out.println("All Employees:");
            employeeDAO.getAllEmployees().forEach(employee -> {
                System.out.println(employee);
            });
        });

        // Scene Setup
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
