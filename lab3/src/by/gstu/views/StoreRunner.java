package by.gstu.views;

import by.gstu.store.services.orders.OrderService;
import by.gstu.store.services.orders.components.Basket;
import by.gstu.store.services.orders.components.products.Bear;
import by.gstu.store.services.orders.components.products.IPhone;
import by.gstu.store.services.orders.components.products.Milk;
import by.gstu.store.services.orders.components.products.Potato;

import java.util.Scanner;

public class StoreRunner {

    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        OrderService orderService = OrderService.getInstance();
	    int k = 0;
	    while(k != 4) {
            menu();
            k = in.nextInt();
            switch (k) {
                case 1:
                    takeOrder(orderService);
                    break;
                case 2:
                    System.out.println(orderService.toString());
                    break;
                case 3:
                    System.out.println("Общая стоимость всех заказов равна: " + orderService.getPrice());
                    break;
                default:
                    break;
            }
        }
    }

    private static void takeOrder(OrderService orderService) {
        Basket basket = new Basket();
        int k = 0;
        while (k != 2) {

            catalog();
            int n = in.nextInt();
            switch (n) {
                case 1:
                    basket.add(new Bear("Лидское", 3));
                    break;
                case 2:
                    basket.add(new IPhone(4500));
                    break;
                case 3:
                    basket.add(new Milk("Мозырь", 1.4));
                    break;
                case 4:
                    basket.add(new Potato("Гомель", 2));
                    break;
                default:
                    System.out.println("Нет тавара в каталоге с таким номером.");
                    break;
            }
            System.out.println("1. Добавить новый товар в корзину.");
            System.out.println("2. Выход с каталога.");
            System.out.print("--> ");
            k = in.nextInt();
            if (k == 2) orderService.add(basket);

        }
    }

    private static void catalog() {
        System.out.println("----------------------");
        System.out.println("|       КАТАЛОГ      |");
        System.out.println("----------------------");
        System.out.println("| 1) Пиво.           |");
        System.out.println("| 2) IPhone.         |");
        System.out.println("| 3) Молоко.         |");
        System.out.println("| 4) Картошка.       |");
        System.out.println("----------------------");
        System.out.print("--> ");
    }

    private static void menu() {
        System.out.println("1) Сделать заказ.");
        System.out.println("2) Посмотреть все заказы.");
        System.out.println("3) Общая стоимость.");
        System.out.println("4) Выход.");
        System.out.print("--> ");
    }
}
