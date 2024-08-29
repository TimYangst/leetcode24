package Interviews.MutipleThreadedLogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MultipleThreadedLogger {

    private ExecutorService executorService;
    private ReentrantLock lock;
    private BufferedWriter writer;

    public MultipleThreadedLogger(int threadPoolSize, String logFilePath) throws IOException {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
        this.lock = new ReentrantLock();
        this.writer = new BufferedWriter(new FileWriter(logFilePath, true));
    }

    public void log(String logText) {
        this.executorService.submit(() -> {
            lock.lock();
            try {
                writer.write(logText);
                writer.newLine();
                writer.flush();
                System.out.println(logText);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
    }

    public void cleanUp() throws IOException {
        try {
            this.executorService.shutdown();
            TimeUnit.SECONDS.sleep(3);
            int retry = 5;
            while (!executorService.isTerminated() && retry > 0) {
                System.out.println("Executor isn't terminated, retrying...");
                retry--;
                TimeUnit.SECONDS.sleep(3);

            }
            this.writer.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.executorService.shutdownNow();
        }
    }

    public static void main(String[] args) {
        try {
            final MultipleThreadedLogger logger = new MultipleThreadedLogger(5, "/Users/tingyang/test/1.log");
            Random random = new Random();
            try {
                for (int i = 0; i < 1000; i++) {
                    Thread thread = new Thread(() -> {
                        logger.log(Thread.currentThread().getName() + ": " + random.nextInt(1000));
                    });
                    thread.setName("New Thread " + i);
                    thread.start();
                }
                TimeUnit.SECONDS.sleep(4);
            } finally {
                logger.cleanUp();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
