package by.gstu.endpoints;

import by.gstu.services.MathServiceImpl;

import javax.xml.ws.Endpoint;

public class EndPoint {
    public static void main(String[] args) {
        MathServiceImpl mathService = new MathServiceImpl();
        String address = "http://localhost:9000/MathService";
        Endpoint.publish(address, mathService);
    }
}
