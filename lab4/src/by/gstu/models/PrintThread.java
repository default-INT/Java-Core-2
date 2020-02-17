package by.gstu.models;

/**
 * Thread get from resource value and print in console.
 *
 * @author Evgeniy Trofimov
 * @version 1.0
 */
public class PrintThread extends Thread {
    private Resources resources;

    public PrintThread(Resources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        System.out.println("Print thread start");
        String value;
        try {
            synchronized (resources) {
                while ((value = resources.poll()) != null) {
                    System.out.println(value);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Print thread finished");
    }
}
