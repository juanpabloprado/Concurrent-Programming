/**
 * Two threads cooking soup
 */

class ChefCintia extends Thread {
    @Override
    public void run() {
        System.out.println("Cintia started & waiting for sausage to thaw...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cintia is done cutting sausage.");
    }
}

public class ThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Luis started & requesting Cintia's help.");
        Thread cintia = new ChefCintia();
        System.out.println(" Cintia state: " + cintia.getState());

        System.out.println("Luis tells Cintia to start.");
        cintia.start();
        System.out.println(" Cintia state: " + cintia.getState());

        System.out.println("Luis continues cooking soup.");
        Thread.sleep(500);
        System.out.println(" Cintia state: " + cintia.getState());

        System.out.println("Luis patiently waits for Cintia to finish and join...");
        cintia.join();
        System.out.println(" Cintia state: " + cintia.getState());

        System.out.println("Luis and Cintia are both done!");
    }
}