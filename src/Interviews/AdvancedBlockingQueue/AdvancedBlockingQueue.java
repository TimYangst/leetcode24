package Interviews.AdvancedBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdvancedBlockingQueue<T> {
    private Queue<T> queue;
    private int capacity;
    private Lock lock;
    private Condition allFull;
    private Condition notEmpty;

    private int pendingMultiAdding;

    public AdvancedBlockingQueue(int capacity) {
        this.capacity = capacity;
        pendingMultiAdding = 0;
        lock = new ReentrantLock();
        queue = new LinkedList<>();
        allFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public void put(T t) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity || pendingMultiAdding > 0) {
                allFull.await();
            }
            queue.offer(t);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T poll() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            T element = queue.poll();
            allFull.signalAll();
            return element;
        } finally {
            lock.unlock();
        }
    }

    public void putAll(T[] items) throws InterruptedException {
        lock.lock();
        try {
            pendingMultiAdding++;
            for (T item : items) {
                while (queue.size() == capacity) {
                    allFull.await();
                }
                queue.offer(item);
                notEmpty.signal();
            }
        } finally {
            pendingMultiAdding--;
            if (pendingMultiAdding == 0) {
                allFull.signalAll();
            }
            lock.unlock();
        }
    }

}
