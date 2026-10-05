package entites;

import java.util.Arrays;

public class DefaultOrder implements Order {

    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

    private String creditCardNumber;
    private Product[] products;
    private int customerId;

    @Override
    public boolean isCreditCardNumberValid(String creditCardNumber) {
        if (creditCardNumber == null || creditCardNumber.isEmpty()||creditCardNumber.contains(" ")) {
            return false;
        }
        Long.parseLong(creditCardNumber);
        return creditCardNumber.matches("\\d{16}");
    }

    @Override
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        return "Order: customer id: " + this.customerId +
                ", credit card number: " + this.creditCardNumber +
                ", products: " + Arrays.toString(this.products);
    }





}
