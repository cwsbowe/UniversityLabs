import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.NumberQueue;

public class CyclicQueue implements NumberQueue{
    int[] array;
    int head;
    int tail;
    boolean space;

    CyclicQueue(int capacity) {
        this.array = new int[capacity];
        this.head = 0;
        this.tail = 0;
        if (capacity > 0) {
            this.space = true;
        } else {
            this.space = false;
        }

    }

    @Override
    public synchronized void enqueue(int i) throws IndexOutOfBoundsException {
        if (space) {
            array[tail] = i;
            if (tail == array.length - 1) {
                tail = 0;
            } else {
                tail++;
            }
            if (head == tail) {
                space = false;
            }
        } else {
            throw (new IndexOutOfBoundsException("No space"));
        }
    }

    @Override
    public synchronized int dequeue() throws IndexOutOfBoundsException {
        if (!this.isEmpty()) {
            int value = array[head];
            if (head == array.length - 1) {
                head = 0;
            } else {
                head++;
            }
            space = true;
            return value;
        }
        else {
            throw (new IndexOutOfBoundsException("Queue is empty"));
        }
    }

    @Override
    public boolean isEmpty() {
        if (space && head == tail) {
            return true;
        } else {
            return false;
        }
    }
}
