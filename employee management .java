import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (option) {
                case 1: // Add Employee
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    employees.add(new Employee(id, name, salary));
                    break;

                case 2: // Update Employee
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    Employee empToUpdate = null;
                    for (Employee emp : employees) {
                        if (emp.id == updateId) {
                            empToUpdate = emp;
                            break;
                        }
                    }
                    if (empToUpdate != null) {
                        System.out.print("Enter new Name: ");
                        empToUpdate.name = sc.nextLine();
                        System.out.print("Enter new Salary: ");
                        empToUpdate.salary = sc.nextDouble();
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3: // Remove Employee
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = sc.nextInt();
                    sc.nextLine();
                    employees.removeIf(emp -> emp.id == removeId);
                    break;

                case 4: // Search Employee
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();
                    boolean found = false;
                    for (Employee emp : employees) {
                        if (emp.id == searchId) {
                            System.out.println(emp);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5: // Display All Employees
                    if (employees.isEmpty()) {
                        System.out.println("No employees in the list.");
                    } else {
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 6: // Exit
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
