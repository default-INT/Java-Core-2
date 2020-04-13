package by.gstu.store.services.users;

import by.gstu.store.services.orders.components.Basket;
import by.gstu.store.services.orders.components.products.Bear;
import by.gstu.store.services.orders.components.products.IPhone;
import by.gstu.store.services.orders.components.products.Milk;
import by.gstu.store.services.orders.components.products.Potato;
import by.gstu.store.services.users.accounts.Administrator;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class AccountContext {
    private Account account;

    private Collection<Account> accounts;

    {
        accounts = new HashSet<>();
        accounts.add(new Administrator(this));
    }

    public AccountContext(int accountId) {
        this.account = accounts.stream()
                               .filter(account -> account.id == accountId)
                               .findFirst()
                               .get();
    }

    public AccountContext() {
    }

    public void changeAccount(Account account) {
        accounts.add(account);
        this.account = account;
    }

    public void changeAccount(int accountId) {
        this.account =  accounts.stream()
                                .filter(account -> account.id == accountId)
                                .findFirst()
                                .get();
    }

    public void takeOrder(PrintStream out, Scanner in) throws Exception {
        Basket basket = new Basket();
        int k = 0;
        while (k != 2) {
            catalogMenu();
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
            out.println("1. Добавить новый товар в корзину.");
            out.println("2. Выход с каталога.");
            out.print("--> ");
            k = in.nextInt();
        }
        account.takeOrder(basket);
    }

    public void printOrders(PrintStream out) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список заказов: ");
        account.getOrders().forEach(order -> stringBuilder.append(order.toString()).append('\n'));
        out.println(stringBuilder.toString());
    }

    public void getPrice(PrintStream out) {
        out.println("Общая сумма всех заказов: " + account.getPrice());
    }

    private static void catalogMenu() {
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
}
