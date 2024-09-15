import java.util.InputMismatchException;
import java.util.Scanner;

public class TestUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Food Inventory System !!");
        System.out.println("Login to ?");
        System.out.println("0: End program");
		System.out.println("1: Admin");
        System.out.println("2: Employee");
        System.out.print("Your choice -> ");
        while (true) {  
            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 0:
                        System.out.println("Bye Bye");
                        System.exit(0);  
                        break;
                    case 1:
                        Admin a = new Admin("Eu Wen Zhan", "Ewz@555", "euzenzhan@gmail.com", "012-3456789");
                        a.login(a);
                        System.out.print("\nThis is your admin details: ");
                        System.out.println(a.toString());
                        break;
                    case 2:
                        Employee employee = new Employee();
                        Employee em1 = new Employee("Kennard Khoo", "Kkpt&666", "kennardkhoo@gmail.com", "019-8765432", 5000.00, "03-05-2019");
                        Employee em2 = new Employee("Tan Wei Khye", "Twk!222", "tanweikhye@gmail.com", "019-3627553", 4000.00, "08-12-2020");
                        Employee em3 = new Employee("Tan Guan Hong", "Tgh*999", "tanguanhong@gmail.com", "011-3532652", 3000.00, "06-07-2023");
                        Employee[] e = {em1, em2, em3};
                        employee.login(e); 
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 0-2");
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number ->");
                sc.nextLine(); 
            }
        }
    }
}
