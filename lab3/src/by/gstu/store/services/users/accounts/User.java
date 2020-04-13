package by.gstu.store.services.users.accounts;

import by.gstu.store.services.orders.Order;
import by.gstu.store.services.orders.OrderService;
import by.gstu.store.services.users.Account;
import by.gstu.store.services.users.AccountContext;

import java.util.Collection;

public class User extends Account {
    private OrderService orderService;

    public User(int id, AccountContext context) {
        super(context);
        this.id = id;
        this.orderService = OrderService.getInstance();
    }

    @Override
    public void takeOrder(Order order) {
        order.setClientId(id);
        orderService.add(order);
    }

    @Override
    public Collection<Order> getOrders() {
        return orderService.getOrders(id);
    }

    @Override
    public double getPrice() {
        return orderService.getPrice(id);
    }
}
