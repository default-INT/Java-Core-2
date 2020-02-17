package by.gstu;

import by.gstu.models.entities.Account;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream out = System.out;
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        out.print("Введите номер счёта: ");
        String number = in.next();
        out.print("Введите начальную сумму счёта: ");
        double sum = in.nextDouble();
        Account account = new Account(number, sum);
        int k = 0;
        while (k != 6) {
            printMenu();
            out.print("-> ");
            k = in.nextInt();
            switch (k) {
                case 1:
                    out.print("Введите сумму: ");
                    sum = in.nextDouble();
                    printResult(account.commitPayment(sum));
                    break;
                case 2:
                    out.print("Введите сумму: ");
                    sum = in.nextDouble();
                    printResult(account.cashWithdrawal(sum));
                    break;
                case 3:
                    out.print("Введите сумму: ");
                    sum = in.nextDouble();
                    account.depositMoney(sum);
                    printResult(true);
                    break;
                case 4:
                    out.println(account.toString());
                    break;
                case 5:
                    out.println(String.format("Баланс: %.2f", account.getMoney()));
                    break;
                case 6:
                    out.println("Выход ....");
                    break;
                default:
                    out.println("Нет такого пункта меню.");
                    break;
            }
        }
    }

    public static void printMenu() {
        out.println("---------------------------------------------");
        out.println("|                   МЕНЮ                    |");
        out.println("---------------------------------------------");
        out.println("| 1) Совершить платёж.                      |");
        out.println("| 2) Снять деньги со счёта.                 |");
        out.println("| 3) Зачислить деньги на счёт.              |");
        out.println("| 4) Вывести информацию о платежах.         |");
        out.println("| 5) Проверить баланс.                      |");
        out.println("---------------------------------------------");
        out.println("|                  ВЫХОД                    |");
        out.println("---------------------------------------------");
    }

    public static void printResult(boolean result) {
        out.println(result ? "Операция успешно совершенна." : "Не удалось совершить операцию.");
    }
}
