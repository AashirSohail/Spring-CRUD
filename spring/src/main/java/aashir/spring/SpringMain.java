package aashir.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class SpringMain {
    Scanner scan = new Scanner(System.in);
    int choice , id;
    person per;

    /*
     * Constructor
     */
    public SpringMain() {
        
    	AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        applicationContext.registerShutdownHook();
        DAOImp hibernateDaoImp = (DAOImp) applicationContext.getBean("hibernateDaoImp");

		System.out.print("\n[1] Add [2] Update [3] Delete\n[4] Get Info [5] Exit Program\nYour Choice:");
        choice = scan.nextInt();
        scan.nextLine();

            switch (choice) {
                case 1:
                    per = getInfo();
                    hibernateDaoImp.register(per);
                    break;

                case 2:
                    System.out.print("Enter ID to Update: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    per = updateInfo(id);
                    per.setId(id);
                    hibernateDaoImp.update(per);
                    break;

                case 3:
                	System.out.print("Enter ID to Delete: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    hibernateDaoImp.delete(id);
                    break;
                    
                case 4:        
                    System.out.print("Enter ID for Info: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    per = hibernateDaoImp.retrieve(id);
                    printPerson(per);
                    break;

                default:
                    System.out.print("Wrong value entered!\nExiting application...\n\n");
            }

        applicationContext.close();
    }



    /*
     * Get information about a person and return an object
     */
    public person getInfo(){
        String name, fatherName, organization, mobile, username, password;
        int id;
        System.out.print("Enter ID: ");
        id = scan.nextInt();
        System.out.print("Enter Name: ");
        name = scan.next();
        System.out.print("Enter Father Name: ");
        fatherName = scan.next();
        System.out.print("Enter Organization: ");
        organization = scan.next();
        System.out.print("Enter Mobile: ");
        mobile = scan.next();
        System.out.print("Enter Username: ");
        username = scan.next();
        System.out.print("Enter Password: ");
        password = scan.next();

        return new person(id,name, fatherName, organization, mobile, username, password);
    }
    
    public person updateInfo(int id){
        String name, fatherName, organization, mobile, username, password;
        
        System.out.print("Enter Name: ");
        name = scan.next();
        System.out.print("Enter Father Name: ");
        fatherName = scan.next();
        System.out.print("Enter Organization: ");
        organization = scan.next();
        System.out.print("Enter Mobile: ");
        mobile = scan.next();
        System.out.print("Enter Username: ");
        username = scan.next();
        System.out.print("Enter Password: ");
        password = scan.next();

        return new person(id,name, fatherName, organization, mobile, username, password);
    }


    /*
     * Takes in a person object
     * Prints out the person object attributes using getter methods
     */
    public void printPerson(person p){
		System.out.println("ID: "+p.id + " Name: " +p.name+" Fname: "+p.fatherName+" Org: "+p.organization+
						   " Mob: "+p.mobile+" User: "+p.username+" Pass: "+p.password+"\n");
    }



    /*
     * Main Method
     */
    public static void main(String[] args) {
        new SpringMain();
    }
}