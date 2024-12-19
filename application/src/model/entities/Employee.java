package model.entities;

public class Employee {

    private String name; // Nome do funcionário
    private String email; // Email do funcionário
    private Double salary; // Salário do funcionário

    // Construtor da classe Employee
    public Employee(String name, String email, Double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // Métodos getters e setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}