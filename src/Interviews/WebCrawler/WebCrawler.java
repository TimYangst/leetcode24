package Interviews.WebCrawler;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WebCrawler {
    private ExecutorService executorService;
    private ExecutorService storageService;
    private Set<String> visitedUrl = ConcurrentHashMap.newKeySet();
    private int maxDepth;

    public WebCrawler(int maxThreads, int maxDepth) {
        executorService = Executors.newFixedThreadPool(maxThreads);
        storageService = Executors.newFixedThreadPool((maxThreads + 1) / 2);
        this.maxDepth = maxDepth;
    }

    private CompletableFuture<Void> crawl(String url, int currentDepth) {
        if (currentDepth > maxDepth || visitedUrl.contains(url)) {
            if (visitedUrl.contains(url)) {
                System.out.println(url + " is fetched..");
            }
            return CompletableFuture.completedFuture(null);
        }
        visitedUrl.add(url);

        return CompletableFuture.supplyAsync(() -> {
            return UtilityFunction.fetch(url);
        }, executorService).thenCompose(content -> {
            CompletableFuture<Void> storageFuture = CompletableFuture.supplyAsync(() -> {
                UtilityFunction.save(content);
                return null;
            }, storageService);
            CompletableFuture<List<String>> parseFuture = CompletableFuture.supplyAsync(() -> {
                return UtilityFunction.parse(content);
            }, executorService);
            return parseFuture.thenCompose(urls -> {
                CompletableFuture<?>[] futures = urls.stream().map(nextUrl -> crawl(nextUrl, currentDepth + 1))
                        .toArray(CompletableFuture[]::new);
                return CompletableFuture.allOf(futures).thenCombine(storageFuture, (a, b) -> null);
            });
        });
    }

    public CompletableFuture<Void> crawl(List<String> seedUrls) {
        CompletableFuture<?>[] futures = seedUrls.stream().map(url -> crawl(url, 0))
                .toArray(CompletableFuture[]::new);
        return CompletableFuture.allOf(futures);
    }

    public void shutdown() {
        this.executorService.shutdown();
        this.storageService.shutdown();
    }

    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler(10, 4);
        CompletableFuture<Void> future = crawler.crawl(List.of("http://www.begin1.com", "http://www.begin2.com"));
        future.join();
        crawler.shutdown();
    }

}
