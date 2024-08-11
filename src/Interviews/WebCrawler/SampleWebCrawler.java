package Interviews.WebCrawler;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class SampleWebCrawler {

    private final ExecutorService executorService;
    private final Set<String> visitedUrls = ConcurrentHashMap.newKeySet();
    private final int maxDepth;
    private final WebParser parser;

    public SampleWebCrawler(int maxDepth, int threadPoolSize, WebParser parser) {
        this.maxDepth = maxDepth;
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
        this.parser = parser;
    }

    public void crawl(String startUrl) {
        List<Future<?>> futures = new CopyOnWriteArrayList<>();
        futures.add(executorService.submit(() -> crawl(startUrl, 0, futures)));

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

    private void crawl(String url, int depth, List<Future<?>> futures) {
        if (depth > maxDepth || !visitedUrls.add(url)) {
            return;
        }

        System.out.println("Crawling: " + url + " at depth " + depth);

        List<String> links = parser.parse(url);

        for (String link : links) {
            futures.add(executorService.submit(() -> crawl(link, depth + 1, futures)));
        }
    }

    public static void main(String[] args) {
        WebParser parser = new SimpleWebParser();
        SampleWebCrawler crawler = new SampleWebCrawler(3, 10, parser);
        crawler.crawl("http://example.com");
    }
}
