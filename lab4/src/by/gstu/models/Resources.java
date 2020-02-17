package by.gstu.models;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Synchronized resource. Implements "Singleton" pattern.
 *
 * @author Evgeniy Trofimov
 * @version 1.0
 */
public class Resources {
    private static Resources instance;
    private  Queue<String> resources;
    private int length = 4;
    private int count;

    private Resources() {
        count = 0;
        resources = new ArrayDeque();
    }

    public static synchronized Resources getInstance() {
        if (instance == null) {
            instance = new Resources();
        }
        return instance;
    }

    public synchronized void offer(String value) throws InterruptedException {
        if (count < length)
            count++;
        else
            wait();
        notifyAll();
        resources.offer(value);

    }

    public synchronized String poll() throws InterruptedException {
        if (count > 0) {
            count--;
            return resources.poll();
        }
        notifyAll();
        wait(100);
        if (count > 0) count--;
        return resources.poll();
    }
}
