package menu;

import context.ApplicationContext;

public class SignOutMenu implements Menu {

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        context.setLoggedInUser(null);
        System.out.println("Have a nice day! Look forward to welcoming back!");
        context.getMainMenu();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("/*** SIGN OUT ***");
    }

}
