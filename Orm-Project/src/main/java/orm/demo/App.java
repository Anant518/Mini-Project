package orm.demo;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDao;
import entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);
    	Scanner scanner = new Scanner(System.in);
    	
    	boolean flag=true;
    	
    	while(flag) 
    	{
    		
    	
    	System.out.println("**************************************");
    	System.out.println("Plz Select the option");
    	System.out.println("1.add the data");
    	System.out.println("2.update the data");
    	System.out.println("3.delete the data");
    	System.out.println("4.get the data");
    	System.out.println("5.get the data by id");
    	System.out.println("6.Exit");
    	int input = scanner.nextInt();
    	
    	
         switch(input) {
         case 1:
        	 
        	 System.out.println("Enter the emp id");
        	 int id = scanner.nextInt();
        	 
        	 System.out.println("Enter the emp name");
        	 String name = scanner.next();
        	 
        	 System.out.println("Enter the emp email");
        	 String email = scanner.next();
        	 
        	 Employee newEmployee = new Employee();
        	 newEmployee.setId(id);
        	 newEmployee.setName(name);
        	 newEmployee.setEmail(email);
        	 
        	 dao.addEmployee(newEmployee);
        	 System.out.println("Data Inserted Suceesfully");
        	 
         	break;
         
         case 2:
        	 
        	 System.out.println("Enter the emp id where you want changes");
        	 int id1 = scanner.nextInt();
        	 
        	 System.out.println("Enter the emp Rename");
        	 String name1 = scanner.next();
        	 
        	 System.out.println("Enter the emp Reemail");
        	 String email1 = scanner.next();
        	 
        	 Employee newEmployee1 = new Employee();
        	 newEmployee1.setId(id1);
        	 newEmployee1.setName(name1);
        	 newEmployee1.setEmail(email1);
        	 
        	 dao.updateEmployee(newEmployee1);
        	 System.out.println("Update Done");
        	 
         	break;
         	
         case 3:
        	 
        	 System.out.println("Enter the emp id where you wanr delete data");
        	 int id2 = scanner.nextInt();
        	 dao.deleteEmployee(id2);
        	 System.out.println("Deleted Succefully");
        	 
         	break;
         	
         case 4:
        	 
        	 System.out.println("list");
        	 List<Employee> emp4 = dao.getAllEmployee();
        	 for(Employee empp : emp4) {
        		 System.out.println(empp);
        		 }
        	 
        	         	 
        	break;
        	
         case 5:

        	 System.out.println("Enter the emp id where you want the data");
        	 int id5 = scanner.nextInt();
        	Employee emp= dao.getEmployeeById(id5);
        	 System.out.println(emp);
        	break;
        	
        	
         case 6:
        	
        	 System.out.println("Thank You");
        	 flag=false;
        	break;
        
         default:
        	 System.out.println("Invalid Choice");
         
         	}
    }
}
}