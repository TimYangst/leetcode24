package Interviews.WebCrawler;

import java.util.List;
import java.util.Random;

public class SimpleWebParser implements WebParser {
    private Random random = new Random();

    @Override
    public List<String> parse(String url) {
        return List.of("http://example.com/link1/" + random.nextInt(10),
                "http://example.com/link2/" + random.nextInt(10));
    }
}

interface WebParser {
    List<String> parse(String url);
}
