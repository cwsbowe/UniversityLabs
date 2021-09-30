public class Gate implements Runnable{
    Counter counter;
    int guests;

    Gate(Counter counter, int guests) {
        this.counter = counter;
        this.guests = guests;
    }

    @Override
    public void run() {
        for (int i = 0; i < guests; i++) {
            counter.addOne();
        }
    }
}
