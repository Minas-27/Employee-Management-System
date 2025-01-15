import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    // Add a new employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Get the list of all employees
    public List<Employee> getEmployees() {
        return employees;
    }

    // Search for an employee by name
    public Employee searchEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    // Delete an employee by name
    public boolean deleteEmployee(String name) {
        Employee employee = searchEmployee(name);
        if (employee != null) {
            employees.remove(employee);
            return true;
        }
        return false;
    }

    // Update an employee's details
    public boolean updateEmployee(String name, int newAge, String newDepartment) {
        Employee employee = searchEmployee(name);
        if (employee != null) {
            employees.remove(employee);
            employees.add(new Employee(name, newAge, newDepartment));
            return true;
        }
        return false;
    }
}
