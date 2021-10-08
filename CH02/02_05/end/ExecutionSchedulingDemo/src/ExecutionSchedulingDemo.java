/**
 * Two threads chopping vegetables
 */

class VegetableChopper extends Thread {

    private int vegetableCount = 0;
    private static boolean chopping = true;

    public VegetableChopper(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (chopping) {
            System.out.println(this.getName() + " chopped a vegetable!");
            vegetableCount++;
        }
    }

    public int getVegetableCount() {
        return vegetableCount;
    }

    public static void setChopping(boolean chopping) {
        VegetableChopper.chopping = chopping;
    }
}

public class ExecutionSchedulingDemo {
    public static void main(String[] args) throws InterruptedException {
        VegetableChopper luis = new VegetableChopper("Luis");
        VegetableChopper cintia = new VegetableChopper("Cintia");

        luis.start();
        cintia.start();
        Thread.sleep(1000);
        VegetableChopper.setChopping(false);

        luis.join();
        cintia.join();
        System.out.format("Luis chopped %d vegetables.%n", luis.getVegetableCount());
        System.out.format("Cintia chopped %d vegetables.%n", cintia.getVegetableCount());
    }
}