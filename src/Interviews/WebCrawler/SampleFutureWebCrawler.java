package Interviews.WebCrawler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class SampleFutureWebCrawler {

    private final ExecutorService executorService;
    private final Set<String> visitedUrls = ConcurrentHashMap.newKeySet();
    private final int maxDepth;
    private final WebParser parser;
    private final SimpleRateLimiter rateLimiter; 

    public SampleFutureWebCrawler(int maxDepth, int threadPoolSize, WebParser parser) {
        this.maxDepth = maxDepth;
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
        this.parser = parser;
        this.rateLimiter = new SimpleRateLimiter(1000);
    }

    public CompletableFuture<Void> crawl(String startUrl) {
        return crawl(startUrl, 0);
    }

    private CompletableFuture<Void> crawl(String url, int depth) {
        if (depth > maxDepth || !visitedUrls.add(url)) {
            return CompletableFuture.completedFuture(null); 
        }

        rateLimiter.acquire(); // rate limiter;

        System.out.println("Crawling: " + url + " at depth " + depth);

        return CompletableFuture.supplyAsync(() -> parser.parse(url), executorService)
                .thenCompose(links -> {
                    CompletableFuture<?>[] futures = links.stream()
                            .map(link -> crawl(link, depth + 1))
                            .toArray(CompletableFuture[]::new);

                    return CompletableFuture.allOf(futures);
                });
    }

    public static void main(String[] args) {
        WebParser parser = new SimpleWebParser();  
        SampleFutureWebCrawler crawler = new SampleFutureWebCrawler(3, 10, parser);

        CompletableFuture<Void> future = crawler.crawl("http://example.com");


        future.join();
        crawler.executorService.shutdown();
    }
}