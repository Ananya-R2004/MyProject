package models;

public class Employee {
    private int employeeId;
    private String name;
    private int departmentId;
    private String position;
    private double salary;

    // Constructor
    public Employee(int employeeId, String name, int departmentId, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.departmentId = departmentId;
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
