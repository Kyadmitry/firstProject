import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SequenceThreadFrame {

    public List<String> sequence() throws InterruptedException {
        CopyOnWriteArrayList<String> out = new CopyOnWriteArrayList<>();
        DoubleLock lock = new DoubleLock();

        Thread first = new Thread(
                () -> {
                    try {
                        lock.firstWait();
                        out.add("first");
                        lock.firstDone();
                        lock.firstWait();
                        out.add("first");
                        lock.firstDone();
                        lock.firstWait();
                        out.add("first");
                        lock.firstDone();
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                }
        );

        Thread second = new Thread(
                () -> {
                    try {
                        lock.secondWait();
                        out.add("second");
                        lock.secondDone();
                        lock.secondWait();
                        out.add("second");
                        lock.secondDone();
                        lock.secondWait();
                        out.add("second");
                        lock.secondDone();
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                }
        );

        first.start();
        second.start();
        first.join();
        second.join();

        return out;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new SequenceThreadFrame().sequence());
    }

    static class DoubleLock {
        boolean first = false;
        boolean second = true;

        synchronized void firstDone() {
            first = false;
            second = true;
            notify();
        }

        synchronized void secondDone() {
            first = true;
            second = false;
            notify();
        }

        synchronized void firstWait() throws InterruptedException {
            while (second) {
                wait();
            }
        }

        synchronized void secondWait() throws InterruptedException {
            while (first) {
                wait();
            }
        }
    }

}
