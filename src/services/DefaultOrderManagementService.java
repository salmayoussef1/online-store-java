package services;

import entites.Order;
import entites.User;

import java.util.Arrays;

public class DefaultOrderManagementService implements OrderManagementService {

    private static final int DEFAULT_ORDER_CAPACITY = 10;

    private static DefaultOrderManagementService instance;

    private Order[] orders;
    private int orderIndex;

    {
        orders = new Order[DEFAULT_ORDER_CAPACITY];
    }
    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if (order == null) {
            return;
        }
        if (orders == null) {
            orders = new Order[DEFAULT_ORDER_CAPACITY];
        }
        if (orderIndex >= orders.length) {
            orders = Arrays.copyOf(orders, orders.length*2);
        }
        orders[orderIndex++] = order;
    }

    @Override
    public Order[] getOrdersByUserId(int userId) {
        int orderbyID =0;
        for(Order order : orders){
            if(order!= null && order.getCustomerId() == userId ){
               orderbyID++;
            }
        }
        Order []Orderslist  =  new Order[orderbyID];
        int index = 0;
        for(Order order : orders){
            if(order!= null && order.getCustomerId() == userId){
                Orderslist[index++]=order;
            }
        }
        return Orderslist;
    }

    @Override
    public Order[] getOrders() {
        int nonNullorders = 0;
        for (Order order : orders) {
            if (order != null) {
                nonNullorders++;
            }
        }
        Order[] ordersArray = new Order[nonNullorders];
        int index = 0;
        for (Order order : orders) {
            if (order != null) {
                ordersArray[index++] = order;
            }
        }
        return ordersArray;
    }

    void clearServiceState() {
        orders = new Order[DEFAULT_ORDER_CAPACITY];
        orderIndex = 0;
    }

}
