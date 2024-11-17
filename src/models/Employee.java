package models;

public class Employee {
    private int id; // Primary key
    private int employeeId; // Unique employee ID
    private String name;
    private String position; // Added
    private double salary; // Added
    private int age;
    private int departmentId;
    private String departmentName; // Optional field for display purposes

    // Constructor for adding/updating employees
    public Employee(int employeeId, String name, String position, double salary, int age, int departmentId) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.age = age;
        this.departmentId = departmentId;
    }

    // Constructor for retrieving employees (with ID and optional department name)
    public Employee(int id, int employeeId, String name, String position, double salary, int age, int departmentId) {
        this.id = id;
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.age = age;
        this.departmentId = departmentId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
