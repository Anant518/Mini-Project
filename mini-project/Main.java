package mini;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        System.out.println("Please select any one options");
        System.out.println("**********************");
        System.out.println("Press 1: Insert data");
        System.out.println("Press 2: Update data");
        System.out.println("Press 3: Delete data");
        System.out.println("Press 4: Get data");
        System.out.println("**********************");

        int option = scanner.nextInt();
        switch (option) {
            case 1: {
                insert();
                break;
            }
            case 2: {
                update();
                break;
            }
            case 3: {
                delete();
                break;
            }
            case 4: {
                get();
                break;
            }
            default: {
                System.out.println("Incorrect options");
            }
        }

    }

    private static void insert() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter EmpId: ");
        int id = scanner.nextInt();

        System.out.print("Enter Employee Name: ");
        String name = scanner.next();

        System.out.print("Enter Employee Email: ");
        String email = scanner.next();

        Employee employee = new Employee(id, name, email);
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        dao.addEmployee(employee);


    }

    private static void update() throws SQLException {

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter EmpId: ");
        int id = scanner1.nextInt();

        System.out.print("Enter Employee ReName: ");
        String name = scanner1.next();

        System.out.print("Enter Employee ReEmail: ");
        String email = scanner1.next();

        Employee employee1 = new Employee(id, name, email);
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        dao.updateEmployee(employee1);

    }

    private static void delete() throws SQLException {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter EmpId: ");
        int id = scanner1.nextInt();
    Employee employee=new Employee(id);
    EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
    dao.deleteEmployee(id);


    }

    private static void get() throws SQLException {

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        List<Employee> list = dao.getEmployees();
        for (Employee emp1 : list) {
            System.out.println(emp1);
        }
    }


}
