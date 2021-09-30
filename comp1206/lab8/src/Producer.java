import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.FactoryWorker;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

import java.util.Random;

public class Producer extends FactoryWorker {

    public Producer(int id, NumberQueue belt) {
        super("Producer", id, belt);
    }

    @Override
    public void message(int number) {
        System.out.println("Producer " + id + " picked " + number + " from the belt.");
    }

    @Override
    public synchronized int action() {
        Random random = new Random();
        int next = random.nextInt();
        belt.enqueue(next);
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
