package menu;
import context.ApplicationContext;
import java.util.Scanner;

public class MainMenu implements Menu {

    public static final String MENU_COMMAND = "menu";
    private static final String EXIT_COMMAND = "exit";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign In"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenuHeader();
            String command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase(EXIT_COMMAND)) {
                System.exit(0);
            }

            switch (command) {
                case "1":
                    new SignUpMenu().start();
                    break;
                case "2":
                    if (context.getLoggedInUser() == null) {
                        new SignInMenu().start();
                    } else {
                        new SignOutMenu().start();
                    }
                    break;
                case "3":
                    new ProductCatalogMenu().start();
                    break;
                case "4":
                    new MyOrdersMenu().start();
                    break;
                case "5":
                    new SettingsMenu().start();
                    break;
                case "6":
                    new CustomerListMenu().start();
                    break;
                default:
                    System.out.println("Only 1, 2, 3, 4, 5 ,6 is allowed. Try one more time.");
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("\n*** MAIN MENU ***");
        if (context.getLoggedInUser() == null) {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
        } else {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
        }
    }
}

