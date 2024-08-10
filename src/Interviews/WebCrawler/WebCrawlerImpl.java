package Interviews.WebCrawler;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebCrawlerImpl {

    private ExecutorService executorService;
    private Set<String> visitedUrl;
    private int maxDepth;
    private WebParser webParser;

    public WebCrawlerImpl(int maxDepth, int nThreads, WebParser webParser) {
        this.executorService = Executors.newFixedThreadPool(nThreads);
        this.maxDepth = maxDepth;
        this.visitedUrl = ConcurrentHashMap.newKeySet();
        this.webParser = webParser;
    }

    private CompletableFuture<Void> crawl(String url, int currentDepth) {
        if (currentDepth > maxDepth)
            return CompletableFuture.completedFuture(null);
        if (!visitedUrl.add(url)) {
            System.out.println("Already crawl: " + url + " at depth: " + currentDepth);
            return CompletableFuture.completedFuture(null);
        }
        System.out.println("Crawling: " + url + " at depth: " + currentDepth);
        return CompletableFuture.supplyAsync(() -> {
            return webParser.parse(url);
        }, executorService)
                .thenCompose(urls -> {
                    CompletableFuture<?>[] result = urls.stream()
                            .map(link -> crawl(link, currentDepth + 1)).toArray(CompletableFuture[]::new);
                    return CompletableFuture.allOf(result);
                });
    }

    private CompletableFuture<Void> crawlUrls(List<String> seedUrls) {
        CompletableFuture<?>[] result = seedUrls.stream().map(url -> crawl(url, 0)).toArray(CompletableFuture[]::new);
        return CompletableFuture.allOf(result);
    }

    public static void main(String[] args) {
        WebParser webParser = new SimpleWebParser();
        WebCrawlerImpl webCrawlerImpl = new WebCrawlerImpl(3, 10, webParser);
        CompletableFuture<Void> result = webCrawlerImpl.crawlUrls(List.of("http://example.com"));
        result.join();
        webCrawlerImpl.executorService.shutdown();
    }

}
