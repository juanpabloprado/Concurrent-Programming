/**
 * Cristian finishes cooking while Moises cleans
 */

class KitchenCleaner extends Thread {
    @SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
    @Override
    public void run() {
        while (true) {
            System.out.println("Moises cleaned the kitchen.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class DaemonThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread moises = new KitchenCleaner();
        moises.start();

        System.out.println("Cristian is cooking...");
        Thread.sleep(600);
        System.out.println("Cristian is cooking...");
        Thread.sleep(600);
        System.out.println("Cristian is cooking...");
        Thread.sleep(600);
        System.out.println("Cristian is done!");
    }
}