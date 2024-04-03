import java.util.concurrent.CopyOnWriteArrayList;

public class TestMainConcurrency {

    static class Foo {
        final CopyOnWriteArrayList<String> out;

        Foo(CopyOnWriteArrayList<String> out) {
            this.out = out;
        }

        void first() {
            out.add("first");
        }

        void second() {
            out.add("second");
        }

        void third() {
            out.add("third");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> out = new CopyOnWriteArrayList<>();
        Foo foo = new Foo(out);

        Thread third = new Thread(
                foo::third
        );

        Thread second = new Thread(
                () -> {
                    try {
                        third.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                    foo.second();
                }
        );

        Thread first = new Thread(
                () -> {
                    try {
                        second.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                    foo.first();
                }
        );

        third.start();
        second.start();
        first.start();

        System.out.println(out);
    }
}
