package com.ar0ne.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable{

    private long            id;
    private String          name;
    private List<Employee>  employees;

    public Department(){
        this.id = 0;
        this.name = "";
        this.employees = new ArrayList<Employee>();
    }

    public Department(String name, long id) {
        this.name = name;
        this.id = id;
        this.employees = new ArrayList<Employee>();
    }

    public Department(long id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        if (this.employees == null) {
            this.employees = new ArrayList<>();
        }
        this.employees.add(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        return !(employees != null ? !employees.equals(that.employees) : that.employees != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
