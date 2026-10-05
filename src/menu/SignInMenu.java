package menu;

import context.ApplicationContext;
import entites.User;
import services.DefaultUserManagementService;
import services.UserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Email ");
        String email = scanner.nextLine();
        System.out.print("Enter your Password ");
        String password = scanner.nextLine();
        User user = userManagementService.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            context.setLoggedInUser(user);
            System.out.println("Glad to see you back " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println("Unfortunately, such login and password doesn’t exist");
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("\n*** SIGN IN ***");
    }
}
