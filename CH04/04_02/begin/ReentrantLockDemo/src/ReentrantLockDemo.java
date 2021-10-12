/**
 * Two shoppers adding garlic and potatoes to a shared notepad
 */

import java.util.concurrent.locks.*;

class Shopper extends Thread {

    static int garlicCount, potatoCount = 0;
    static Lock pencil = new ReentrantLock();

    private void addGarlic() {
        pencil.lock();
        garlicCount++;
        pencil.unlock();
    }

    private void addPotato() {
        pencil.lock();
        potatoCount++;
        pencil.unlock();
    }

    public void run() {
        for (int i=0; i<10_000; i++) {
            addGarlic();
            addPotato();
        }
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread gerardo = new Shopper();
        Thread fernanda = new Shopper();
        gerardo.start();
        fernanda.start();
        gerardo.join();
        fernanda.join();
        System.out.println("We should buy " + Shopper.garlicCount + " garlic.");
        System.out.println("We should buy " + Shopper.potatoCount + " potatoes.");
    }
}