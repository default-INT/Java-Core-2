package by.gstu.views;

import by.gstu.store.services.users.AccountContext;
import by.gstu.store.services.users.accounts.Administrator;
import by.gstu.store.services.users.accounts.User;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Scanner;

public class ClientStoreRunner {

    private static Scanner in;
    private static PrintStream out;

    private static Collection<User> users;
    private static Administrator administrator;
    private static AccountContext accountContext;

    public ClientStoreRunner() {

    }

    public static void main(String[] args) {
        int k = 0;
        in = new Scanner(System.in);
        out = System.out;
        accountContext = new AccountContext();
        while (k != 4) {
            logInMenu();
            k = in.nextInt();
            switch (k) {
                case 1:
                    accountContext.changeAccount(0);
                    adminMenu();
                    break;
                case 2:
                    out.print("Введите id клиента: ");
                    int clientId = in.nextInt();
                    accountContext.changeAccount(clientId);
                    try {
                        clientMenu();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    out.print("Введите id клиента: ");
                    int id = in.nextInt();
                    accountContext.changeAccount(new User(id, accountContext));
                    try {
                        clientMenu();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case 4:
                    break;
                default:
                    break;
            }
        }
    }

    private static void adminMenu() {
        int k = 0;
        while (k != 3) {
            out.println("1. Вывести все заказы.");
            out.println("2. Стоимость всех заказов.");
            out.println("3. Выход.");
            out.print("--> ");
            k = in.nextInt();
            switch (k) {
                case 1:
                    accountContext.printOrders(out);
                    break;
                case 2:
                    accountContext.getPrice(out);
                    break;
                case 3:
                    break;
                default:
                    out.println("Нет такого пункта меню.");
                    break;
            }
        }
    }

    private static void clientMenu() throws Exception {
        int k = 0;
        while (k != 4) {
            out.println("1. Сделать заказ.");
            out.println("2. Вывести все заказы.");
            out.println("3. Стоимость всех заказов.");
            out.println("4. Выход.");
            out.print("--> ");
            k = in.nextInt();
            switch (k) {
                case 1:
                    accountContext.takeOrder(out, in);
                    break;
                case 2:
                    accountContext.printOrders(out);
                    break;
                case 3:
                    accountContext.getPrice(out);
                case 4:
                    break;
                default:
                    out.println("Нет такого пункта меню.");
                    break;
            }
        }
    }

    private static void logInMenu() {
        System.out.println("-------------------------");
        System.out.println("|       АВТОРИЗАЦИЯ     |");
        System.out.println("-------------------------");
        System.out.println("| 1) Войти как админ.   |");
        System.out.println("| 2) Войти как клиент.  |");
        System.out.println("| 3) Зарегистрироваться.|");
        System.out.println("| 4) Выход.             |");
        System.out.println("-------------------------");
        System.out.print("--> ");
    }
}
