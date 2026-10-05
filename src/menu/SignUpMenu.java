package menu;

import context.ApplicationContext;
import entites.DefaultUser;
import entites.User;
import services.DefaultUserManagementService;
import services.UserManagementService;

import java.util.Scanner;

public class SignUpMenu implements Menu {

    private UserManagementService userManagementService;
    private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
     printMenuHeader();
     Scanner sc = new Scanner(System.in);

     System.out.println("Enter your First Name:");
     String firstName = sc.nextLine();

     System.out.println("Enter your Last Name:");
     String lastName = sc.nextLine();

     System.out.println("Enter your Password:");
     String password = sc.nextLine();

     System.out.println("Enter your Email:");
     String email = sc.nextLine();

     User newUser = new DefaultUser(firstName, lastName, password, email);
     String errorMessage = userManagementService.registerUser(newUser);
     if (errorMessage != null && !errorMessage.isEmpty()) {
            System.out.println(errorMessage);
        } else {
            context.setLoggedInUser(newUser);
            System.out.println("New user is created");
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("\n*** SIGN UP ***");
    }

}
