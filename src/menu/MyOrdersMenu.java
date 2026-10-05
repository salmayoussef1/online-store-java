package menu;

import context.ApplicationContext;
import entites.Order;
import services.DefaultOrderManagementService;
import services.OrderManagementService;

public class MyOrdersMenu implements Menu {

    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
           if(context.getLoggedInUser() == null) {
               System.out.println("Please, log in or create new account to see list of your orders");
               return;
           }
           printMenuHeader();

        Order[] myOrders = orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());
        if( myOrders == null|| myOrders.length == 0 ) {
            System.out.println("Unfortunately, you don’t have any orders yet. " +
                    "Navigate back to main menu to place a new order");
        }
        else  {
            for(Order order : myOrders) {
                if (order != null){
                System.out.println(order);
                }
            }
        }

    }


    @Override
    public void printMenuHeader() {
        System.out.println("\n*** MY ORDERS ***");

    }

}
