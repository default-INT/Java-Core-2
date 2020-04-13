package by.gstu.store.services.users;

import by.gstu.store.services.orders.Order;

import java.util.Collection;

/**
 * Объект "состояние"
 */
public abstract class Account {
    protected AccountContext context;
    protected int id;

    public Account(AccountContext context) {
        this.context = context;
    }

    public abstract void takeOrder(Order order) throws Exception;
    public abstract Collection<Order> getOrders();
    public abstract double getPrice();

    public int getId() {
        return id;
    }
}
