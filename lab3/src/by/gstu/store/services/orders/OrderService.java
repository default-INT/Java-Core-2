package by.gstu.store.services.orders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private static OrderService instance;
    private List<Order> orders;

    private OrderService() {
        orders = new ArrayList<>();
    }

    public static OrderService getInstance() {
        if (instance == null) instance = new OrderService();
        return instance;
    }

    public void add(Order order) {
        orders.add(order);
    }

    public void remove(int id) {
        orders.remove(id);
    }

    public double getPrice() {
        return orders.stream().mapToDouble(Order::getPrice).sum();
    }

    public double getPrice(int clientId) {
        return orders.stream().filter(order -> order.getClientId() == clientId)
                              .mapToDouble(Order::getPrice)
                              .sum();
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public Collection<Order> getOrders(int clientId) {
        return orders.stream().filter(order -> order.getClientId() == clientId)
                              .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Integer i = 0;
        orders.forEach(o -> stringBuilder.append(i).append(o.toString()).append('\n'));
        return "OrderService{" +
                "orders=[\n" + stringBuilder.toString() +
                "]}";
    }
}
