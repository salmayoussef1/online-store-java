package menu;

import context.ApplicationContext;
import entites.DefaultUser;
import entites.User;
import services.DefaultUserManagementService;
import services.UserManagementService;

public class CustomerListMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        User[] user = userManagementService.getUsers();
        for (User u : user) {
            if (user != null) {
                System.out.println(u);
            }
        }
    }

    @Override
    public void printMenuHeader() {
         System.out.println("\n*** CUSTOMERS ***");
    }

}
