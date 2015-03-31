package concurrency;

import java.io.*;
import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/SimplePriorities.java && java concurrency.SimplePriorities
 *         
 * OUTPUT:
 *         
 */

public class SimplePriorities {

    private int countDown = 5;

    private volatile double d;

    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double)i;

                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }

            System.out.println(this);

            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }

        exec.execute(new SimplePriorities(Tgread.MAX_PRIORITY));

        exec.shutdown();
    }
}