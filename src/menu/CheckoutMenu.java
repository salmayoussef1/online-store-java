package menu;

import context.ApplicationContext;
import entites.DefaultOrder;
import entites.Order;
import services.DefaultOrderManagementService;
import services.OrderManagementService;

import java.util.Scanner;

public class CheckoutMenu implements Menu {

    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
     printMenuHeader();
     Scanner input = new Scanner(System.in);
     while (true) {
         System.out.println("Enter your credit card number without spaces and press enter if you confirm purchase");
         String creditCardNumber = input.nextLine();
         Order newOrder = new DefaultOrder();
         if(newOrder.isCreditCardNumberValid(creditCardNumber)){
             newOrder.setCreditCardNumber(creditCardNumber);
             newOrder.setCustomerId(context.getLoggedInUser().getId());
             newOrder.setProducts(context.getSessionCart().getProducts());
             orderManagementService.addOrder(newOrder);
             context.getSessionCart().clear();
             System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
             break;
         }
         else{
             System.out.println("You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time.");
         }
     }

    }

    @Override
    public void printMenuHeader() {
        System.out.println("\n*** CHECKOUT ***");    }

}
