public class Zoo {
    public static void main(String args[]) {
        Counter counter = new Counter();
        Gate gate0 = new Gate(counter, 0);
        Gate gate1 = new Gate(counter, 1);
        Gate gate2 = new Gate(counter, 2);
        Gate gate3 = new Gate(counter, 3);
        Gate gate4 = new Gate(counter, 4);
        Gate gate5 = new Gate(counter, 5);
        Thread thread0 = new Thread(gate0);
        thread0.start();
        Thread thread1 = new Thread(gate1);
        thread1.start();
        Thread thread2 = new Thread(gate2);
        thread2.start();
        Thread thread3 = new Thread(gate3);
        thread3.start();
        Thread thread4 = new Thread(gate4);
        thread4.start();
        Thread thread5 = new Thread(gate5);
        thread5.start();
        System.out.println(counter.getCounter());
    }
}
