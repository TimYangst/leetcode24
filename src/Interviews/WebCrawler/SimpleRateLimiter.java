package Interviews.WebCrawler;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleRateLimiter {
    private final long maxTokens;          
    private final long refillIntervalNanos; 
    private long availableTokens;          
    private long lastRefillTime;          
    private final ReentrantLock lock = new ReentrantLock(); 

    public SimpleRateLimiter(double permitsPerSecond) {
        this.maxTokens = (long) permitsPerSecond;
        this.refillIntervalNanos = TimeUnit.SECONDS.toNanos(1) / maxTokens;
        this.availableTokens = maxTokens;
        this.lastRefillTime = System.nanoTime();
    }

    public void acquire() {
        lock.lock();
        try {
            refill();
            if (availableTokens > 0) {
                availableTokens--;
            } else {
                long sleepTime = refillIntervalNanos - (System.nanoTime() - lastRefillTime);
                if (sleepTime > 0) {
                    TimeUnit.NANOSECONDS.sleep(sleepTime);
                }
                availableTokens--;
                lastRefillTime = System.nanoTime();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    private void refill() {
        long now = System.nanoTime();
        long tokensToAdd = (now - lastRefillTime) / refillIntervalNanos;
        if (tokensToAdd > 0) {
            availableTokens = Math.min(maxTokens, availableTokens + tokensToAdd);
            lastRefillTime = now;
        }
    }
}
