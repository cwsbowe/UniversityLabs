import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

import java.util.Random;

public class Consumer extends FactoryWorker {

    public Consumer(int id, NumberQueue belt) {
        super("Consumer", id, belt);
    }

    @Override
    public void message(int number) {
        System.out.println("Consumer " + id + " picked " + number + " from the belt.");
    }

    @Override
    public synchronized int action() {
        int next = belt.dequeue();
        return next;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                action();
            } catch (Exception e) {
                messageError();
            }
        }
    }
}
