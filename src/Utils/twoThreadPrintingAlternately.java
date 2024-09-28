package Utils;

public class twoThreadPrintingAlternately {
    private static final Object lock = new Object();
    private static int count = 0;
    private static final int MAX = 200;
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Printer(), "线程1");
        Thread thread2 = new Thread(new Printer(), "线程2");
        thread1.start();
        thread2.start();
    }
    static class Printer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count > MAX) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "打印数字: " + count++);
                    lock.notify();
                    try {
                        if (count <= MAX) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}