package menu;

import context.ApplicationContext;
import entites.Product;
import services.DefaultProductManagementService;
import services.ProductManagementService;

import java.util.Scanner;

public class ProductCatalogMenu implements Menu {

    private static final String CHECKOUT_COMMAND = "checkout";
    private ApplicationContext context;
    private ProductManagementService productManagementService;

    {
        context = ApplicationContext.getInstance();
        productManagementService = DefaultProductManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        printProducts();

        Scanner scanner = new Scanner(System.in);
        while (true) {
        System.out.println("Enter product id to add it to the cart or ‘menu’ " +
                "if you want to navigate back to the main menu’");
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
                break;}
            if (choice.equalsIgnoreCase(CHECKOUT_COMMAND)) {
                if (context.getSessionCart().isEmpty()) {
                    System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
                    continue;
                }
                if (context.getLoggedInUser() == null) {
                    System.out.println("You are not logged in. Please, sign in or create new account");
                    break;
                }
                new CheckoutMenu().start();
                break;
            }
            Product productToAdd = null;
            try {
                int productId = Integer.parseInt(choice);
                productToAdd = productManagementService.getProductById(productId);
            } catch (NumberFormatException e) {
            }
            if (productToAdd != null) {
                context.getSessionCart().addProduct(productToAdd);
                System.out.println("Product " + productToAdd.getProductName() + " has been added to your cart. " +
                        "If you want to add a new product - enter the product id. " +
                        "If you want to proceed with checkout - enter word 'checkout' to console");
            }else {
                System.out.println("Please, enter product ID if you want to add product to cart. " +
                        "Or enter 'checkout' if you want to proceed with checkout. " +
                        "Or enter 'menu' if you want to navigate back to the main menu.");
            }

        }

    }
       private  void printProducts(){
           Product [] products = DefaultProductManagementService.getInstance().getProducts();
           if (products != null){
               for (Product product : products) {
                   System.out.println(product);
               }
           }
       }
        @Override
        public void printMenuHeader () {
            System.out.println("\n*** PRODUCT CATALOG ***");
    }

}
