package menu;

import context.ApplicationContext;

import java.util.Scanner;

public class ChangeEmailMenu implements Menu {

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new email address: ");
        String email = sc.nextLine();
        if (context.getLoggedInUser() != null) {
            context.getLoggedInUser().setEmail(email);
        }
        System.out.println("Your email has been successfully changed");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("\n*** Change Email ***");
    }

}
