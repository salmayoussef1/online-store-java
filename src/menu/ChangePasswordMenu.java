package menu;

import context.ApplicationContext;

import java.util.Scanner;

public class ChangePasswordMenu implements Menu {

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new password: ");
        String password = sc.nextLine();
        if (context.getLoggedInUser() != null) {
            context.getLoggedInUser().setPassword(password);
        }
        System.out.println("Your password has been successfully changed");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("\n*** CHANGE PASSWORD ***");
    }
}
