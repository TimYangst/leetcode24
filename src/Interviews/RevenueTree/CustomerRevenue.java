package Interviews.RevenueTree;

import java.util.*;

public class CustomerRevenue {
    private int cid = 1;
    private final TreeMap<Integer, HashSet<Integer>> revenueMap = new TreeMap<>();
    private final HashMap<Integer, Integer> cidMap = new HashMap<>();

    public void insert(int revenue) {
        cidMap.put(cid, revenue);
        revenueMap.computeIfAbsent(revenue, v -> new HashSet<>()).add(cid);
        cid++;
    }

    public void insert(int revenue, int referralId) {
        cidMap.put(cid, revenue);
        cid++;
        if (cidMap.containsKey(referralId)) {
            int referralRevenue = cidMap.get(referralId);
            if (revenueMap.containsKey(referralRevenue)) {
                revenueMap.get(referralRevenue).remove(referralId);
                if (revenueMap.get(referralRevenue).size() == 0) {
                    revenueMap.remove(referralRevenue);
                }
                revenueMap.computeIfAbsent(
                        referralRevenue + revenue, e -> new HashSet<>()).add(referralId);
                cidMap.put(referralId, referralRevenue + revenue);
            }
        }
    }

    public List<Integer> getKLowestRevenue(int k, int targetRevenue) {
        List<Integer> result = new ArrayList<>();
        int current = targetRevenue;
        for (int i = 0; i < k; i++) {
            int key = revenueMap.higherKey(current);
            result.addAll(revenueMap.get(key));
            current = key;
        }
        return result;
    }

    public void testCustomerRevenue() {
        this.insert(100);
        this.insert(100);
        this.insert(200);
        this.insert(200);
        this.insert(300);
        this.insert(400);

        this.insert(100, 2);

    }
}