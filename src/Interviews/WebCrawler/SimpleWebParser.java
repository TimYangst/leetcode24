package Interviews.WebCrawler;
import java.util.List;

public class SimpleWebParser implements WebParser {
    @Override
    public List<String> parse(String url) {
        return List.of("http://example.com/link1", "http://example.com/link2"); 
    }
}

interface WebParser {
    List<String> parse(String url);
}
