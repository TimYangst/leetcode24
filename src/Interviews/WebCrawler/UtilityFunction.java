package Interviews.WebCrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UtilityFunction {

    private static String BASE_URL = "http://www.test.com/base";

    public static String fetch(String url) {
        System.out.println(String.format("Fetched: %s", url));
        return url;
    }

    public static List<String> parse(String url) {
        Random random = new Random();
        List<String> result = new ArrayList<>();
        System.out.println("Parsing: " + url);
        for (int i = 0; i < random.nextInt(5); i++) {
            result.add(BASE_URL + random.nextInt(10));
        }
        System.out.println(url + result);
        return result;
    }

    public static void save(String url) {
        System.out.println("Saving: " + url);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }
    }

}
