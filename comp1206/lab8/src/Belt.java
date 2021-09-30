public class Belt extends CyclicQueue{
    private Object enqueueObject = new Object();
    private Object dequeueObject = new Object();
    boolean consumerFlag = true;
    boolean producerFlag = true;
    Belt(int capacity) {
        super(capacity);
    }

    @Override
    public void enqueue(int i) throws IndexOutOfBoundsException {
//        if (flag) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        flag = false;
//        this.notify();
//        super.enqueue(i);

//        if (!space) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                return;
//            }
//        } else {
//            this.notify();
//        }
//        super.enqueue(i);

        synchronized (enqueueObject) {
            if (!space) {
                try {
                    enqueueObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (!consumerFlag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
            consumerFlag = false;
            enqueueObject.notifyAll();
            super.enqueue(i);
            consumerFlag = true;
        }

//        synchronized (enqueueObject) {
//            while (!space) {
//                try {
//                    enqueueObject.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    return;
//                }
//            }
//            enqueueObject.notifyAll();
//            super.enqueue(i);
//        }
    }

    @Override
    public synchronized int dequeue() throws IndexOutOfBoundsException {
//        if (!flag) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        flag = true;
//        this.notify();
//        return super.dequeue();

//        if (isEmpty()) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                return 0;
//            }
//        } else {
//            this.notify();
//        }
//        return super.dequeue();

        synchronized (dequeueObject) {
            if (isEmpty()) {
                try {
                    dequeueObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
            if (!producerFlag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
            producerFlag = false;
            int i = super.dequeue();
            producerFlag = true;
            dequeueObject.notifyAll();
            return i;

        }

//        synchronized (dequeueObject) {
//            while (isEmpty()) {
//                try {
//                    dequeueObject.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    return 0;
//                }
//            }
//            dequeueObject.notifyAll();
//            return super.dequeue();
//        }
    }
}
