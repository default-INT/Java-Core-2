package by.gstu.store.services.orders;

public abstract class Order {
    protected int clientId;

    public Order(int clientId) {
        this.clientId = clientId;
    }

    public Order() {

    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public abstract double getPrice();
}
