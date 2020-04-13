package by.gstu.store.services.users.accounts;

import by.gstu.store.services.orders.Order;
import by.gstu.store.services.orders.OrderService;
import by.gstu.store.services.users.Account;
import by.gstu.store.services.users.AccountContext;

import java.util.Collection;

public class Administrator extends Account {
    private OrderService orderService;

    public Administrator(AccountContext context) {
        super(context);
        this.id = 0;
        orderService = OrderService.getInstance();
    }

    @Override
    public void takeOrder(Order order) throws Exception {
        throw new Exception("Данный пользователь не может совершить заказ");
    }

    @Override
    public Collection<Order> getOrders() {
        return orderService.getOrders();
    }

    @Override
    public double getPrice() {
        return orderService.getPrice();
    }
}
