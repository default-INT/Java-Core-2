package by.gstu.views;

import by.gstu.models.CalcThread;
import by.gstu.models.PrintThread;
import by.gstu.models.Resources;

/**
 * Вариант 3. Реализуемые функции: sin(x), cos(x).
 *
 * @author Evgeniy Trofimov
 * @version 1.0
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Resources resources = Resources.getInstance();
        CalcThread sinThread = new CalcThread(0, 5.5, 0.1, "sin", resources) {
            @Override
            public double Func(double x) {
                return Math.sin(x);
            }
        };
        CalcThread cosThread = new CalcThread(5.5, 10, 0.1, "cos", resources) {
            @Override
            public double Func(double x) {
                return Math.cos(x);
            }
        };
        PrintThread printThread = new PrintThread(resources);
        printThread.start();
        sinThread.start();
        cosThread.start();

        System.out.println("Main thread finished");
    }
}
