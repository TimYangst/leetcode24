package Interviews.TopKHitter;

import java.util.*;

class HeavyHitter {
    private String event;
    private int frequency;

    public HeavyHitter(String event, int frequency) {
        this.event = event;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public String getEvent() {
        return this.event;

    }
}

public class TopKHitter {
    public List<HeavyHitter> topK(String[] events, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String event : events) {
            frequencyMap.put(event, frequencyMap.getOrDefault(event, 0));
        }

        PriorityQueue<HeavyHitter> heap = new PriorityQueue<HeavyHitter>(Comparator.comparing(e -> e.getFrequency()));
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            heap.add(new HeavyHitter(entry.getKey(), entry.getValue()));
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<HeavyHitter> result = new ArrayList<>();
        while (heap.size() > 0) {
            result.add(heap.poll());
        }
        return result;
    }

}
