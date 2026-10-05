package menu;

import context.ApplicationContext;

import java.util.Scanner;

public class SettingsMenu implements Menu {

    private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
            + "2. Change Email";

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        if(context.getLoggedInUser() == null){
            System.out.println("Please, log in or create new account to change your account settings");
            return;
        }
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(SETTINGS);
            String choice = sc.nextLine().trim();
            if (choice.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
                break;
            }
            if (choice.equals("1")) {
                new ChangePasswordMenu().start();
                break;
            } else if (choice.equals("2")) {
                new ChangeEmailMenu().start();
                break;
            } else {
                System.out.println("Only 1, 2 is allowed. Try one more time");
            }
        }
    }


    @Override
    public void printMenuHeader() {
        System.out.println("\n*** SETTINGS ***");
    }

}
