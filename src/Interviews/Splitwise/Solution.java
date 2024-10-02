package Interviews.Splitwise;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Transcation {
    String payer;
    double amount;
    List<String> payees;

    public Transcation(String payer, double amount, List<String> payees) {
        this.payer = payer;
        this.amount = amount;
        this.payees = payees;
    }
}

public class Solution {

    private void resolveBidirection(double[][] relationMap, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (relationMap[i][j] > 0 && relationMap[j][i] > 0) {
                    double amount = Math.min(relationMap[i][j], relationMap[j][i]);
                    relationMap[i][j] -= amount;
                    relationMap[j][i] -= amount;
                }
            }
        }
    }

    List<Map.Entry<Map.Entry<String, String>, Double>> getCleanedTranscations(List<Transcation> transcations) {
        List<Map.Entry<Map.Entry<String, String>, Double>> result = new ArrayList<>();
        AtomicInteger index = new AtomicInteger(0);
        Map<String, Integer> idIndex = new HashMap<>();
        Map<Integer, String> reverseIndex = new HashMap<>();

        for (Transcation transcation : transcations) {
            idIndex.computeIfAbsent(transcation.payer, key -> index.getAndIncrement());
            reverseIndex.put(idIndex.get(transcation.payer), transcation.payer);
            for (String payee : transcation.payees) {
                idIndex.computeIfAbsent(payee, key -> index.getAndIncrement());
                reverseIndex.put(idIndex.get(payee), payee);
            }
        }
        double[][] relationMap = new double[index.get()][index.get()];
        for (Transcation transcation : transcations) {
            int payerId = idIndex.get(transcation.payer);
            double amount = transcation.amount / transcation.payees.size();
            for (String payee : transcation.payees) {
                int payeeId = idIndex.get(payee);
                if (payeeId != payerId)
                    relationMap[payeeId][payerId] += amount;
            }
        }
        resolveBidirection(relationMap, index.get());

        for (int k = 0; k < index.get(); k++) {
            for (int i = 0; i < index.get(); i++) {
                if (i == k)
                    continue;
                for (int j = 0; j < index.get(); j++) {
                    if (i == j || j == k)
                        continue;
                    if (relationMap[i][k] > 0 && relationMap[k][j] > 0) {
                        double amount = Math.min(relationMap[i][k], relationMap[k][j]);
                        relationMap[i][k] -= amount;
                        relationMap[k][j] -= amount;
                        relationMap[i][j] += amount;
                    }
                }
            }
            resolveBidirection(relationMap, index.get());
        }
        for (int i = 0; i < index.get(); i++) {
            for (int j = 0; j < index.get(); j++) {
                if (relationMap[i][j] > 0) {
                    SimpleEntry<String, String> entry = new SimpleEntry<>(
                            reverseIndex.get(i), reverseIndex.get(j));
                    SimpleEntry<Map.Entry<String, String>, Double> item = new SimpleEntry<>(entry, relationMap[i][j]);
                    result.add(item);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Transcation> transcations = new ArrayList<>();
        Transcation t1 = new Transcation("A", 1000, List.of("B", "A"));
        Transcation t2 = new Transcation("B", 500, List.of("C"));
        transcations.add(t1);
        transcations.add(t2);
        System.out.println(new Solution().getCleanedTranscations(transcations));
    }

}
