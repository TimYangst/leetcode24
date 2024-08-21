package Interviews.Preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Concurrents {

    public static void main(String[] args) {

        // new SemaphoreRunner().run();
        // new ReentrantLockRunner().run();
        new CyclicBarrierRunner().run();
    }
}

class CyclicBarrierRunner implements Runnable {
    final Random random = new Random();

    @Override
    public void run() {
        CyclicBarrier barrier = new CyclicBarrier(3);

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Thread reached barrier");
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Thread passed barrier");
        };

        new Thread(task, "task1").start();
        new Thread(task, "task2").start();
        new Thread(task, "task3").start();
    }
}

class ReentrantLockRunner implements Runnable {

    private final List<String> sharedList = new ArrayList<>();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    // Method to read the list
    public void readList() {
        readLock.lock(); // Acquire the read lock
        try {
            System.out.println(Thread.currentThread().getName() + " Reading: " + sharedList);
        } finally {
            readLock.unlock(); // Always release the lock in a finally block
        }
    }

    // Method to write to the list
    public void writeList(String item) {
        writeLock.lock(); // Acquire the write lock
        try {
            System.out.println(Thread.currentThread().getName() + " Writing: " + item);
            sharedList.add(item);
        } finally {
            writeLock.unlock(); // Always release the lock in a finally block
        }
    }

    @Override
    public void run() {
        // Creating multiple read threads
        Runnable readTask = () -> {
            for (int i = 0; i < 5; i++) {
                this.readList();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Creating multiple write threads
        Runnable writeTask = () -> {
            for (int i = 0; i < 5; i++) {
                this.writeList("Item " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Starting read threads
        Thread readThread1 = new Thread(readTask, "ReadThread-1");
        Thread readThread2 = new Thread(readTask, "ReadThread-2");

        // Starting write threads
        Thread writeThread1 = new Thread(writeTask, "WriteThread-1");
        Thread writeThread2 = new Thread(writeTask, "WriteThread-2");

        readThread1.start();
        readThread2.start();
        writeThread1.start();
        writeThread2.start();

    }
}

class SemaphoreRunner implements Runnable {

    @Override
    public void run() {
        Semaphore semaphore = new Semaphore(3);

        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println("Thread acquired permit");
                TimeUnit.SECONDS.sleep(1);
                // Critical section
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }

}