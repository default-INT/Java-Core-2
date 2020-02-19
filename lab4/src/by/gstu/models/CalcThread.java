package by.gstu.models;

/**
 * Thread is calculating function value in the range from x1 to x2 in increments h
 * and puts the value in queue.
 *
 * @author Evgeniy Trofimov
 * @version 1.0
 */
public abstract class CalcThread extends Thread {
    private double x1;
    private double x2;
    private double h;
    private final Resources resources;
    private String funcName;

    public CalcThread(double x1, double x2, double h, String funcName, Resources resources) {
        this.x1 = x1;
        this.x2 = x2;
        this.h = h;
        this.resources = resources;
        this.funcName = funcName;
    }

    @Override
    public void run() {
        System.out.println(funcName + " thread start");
        double x = x1;
        try {
            synchronized (resources) {
                while (x <= x2) {
                    resources.offer(String.format("%s(%.2f) = %.2f", funcName, x, Func(x)));
                    x += h;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(funcName + " thread finished");
    }

    public abstract double Func(double x);
}
