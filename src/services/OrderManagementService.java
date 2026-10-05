package services;

import entites.Order;

public interface OrderManagementService {

    void addOrder(Order order);

    Order[] getOrdersByUserId(int userId);

    Order[] getOrders();

}
