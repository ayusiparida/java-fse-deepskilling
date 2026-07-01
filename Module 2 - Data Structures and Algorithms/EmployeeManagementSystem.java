class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return employeeId + " " + name + " " + position + " " + salary;
    }
}

public class EmployeeManagementSystem {

    static Employee[] employees = new Employee[100];
    static int count = 0;

    public static void addEmployee(Employee employee) {
        employees[count++] = employee;
    }

    public static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public static void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                count--;
                break;
            }
        }
    }

    public static void main(String[] args) {
        addEmployee(new Employee(101, "Aadira", "Developer", 50000));
        addEmployee(new Employee(102, "Rahul", "Tester", 40000));

        traverseEmployees();

        System.out.println(searchEmployee(101));

        deleteEmployee(102);

        System.out.println("\nAfter Deletion:");
        traverseEmployees();
    }
}