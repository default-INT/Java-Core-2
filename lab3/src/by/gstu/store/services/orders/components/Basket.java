package by.gstu.store.services.orders.components;

import by.gstu.store.services.orders.Order;

import java.util.ArrayList;
import java.util.Collection;

public class Basket extends Order {

    private Collection<Product> products;

    public Basket() {
        products = new ArrayList<>();
    }

    public void add(Product product) {
        products.add(product);
    }

    public void remove(Product product) {
        products.remove(product);
    }

    @Override
    public void setClientId(int clientId) {
        this.clientId = clientId;
        products.forEach(product -> product.setClientId(clientId));
    }

    @Override
    public double getPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder prodStr = new StringBuilder();
        products.forEach(product -> prodStr.append(product).append("\n"));
        return "Basket{" +
                "products=\n[" + prodStr.toString() +
                "]\n}";
    }
}
