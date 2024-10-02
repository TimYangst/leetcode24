package Interviews.Currency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyConverter {
    private static final double NO_CONVERSION = -1.0;

    // 使用 Floyd-Warshall 算法预计算所有货币之间的转换汇率
    public static Map<String, Map<String, Double>> precomputeRates(List<String[]> rates) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // 构建基础的图结构
        for (String[] rate : rates) {
            String from = rate[0];
            String to = rate[1];
            double conversionRate = Double.parseDouble(rate[2]);

            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());

            graph.get(from).put(to, conversionRate);
            graph.get(to).put(from, 1 / conversionRate);
        }

        // 使用 Floyd-Warshall 算法进行预处理
        for (String k : graph.keySet()) {
            for (String i : graph.keySet()) {
                for (String j : graph.keySet()) {
                    if (graph.get(i).containsKey(k) && graph.get(k).containsKey(j)) {
                        double rateIK = graph.get(i).get(k);
                        double rateKJ = graph.get(k).get(j);

                        graph.get(i).put(j, rateIK * rateKJ);
                    }
                }
            }
        }

        return graph;
    }

    // 查询汇率转换
    public static double queryConversionRate(Map<String, Map<String, Double>> precomputedGraph, String fromCurrency,
            String toCurrency) {
        if (!precomputedGraph.containsKey(fromCurrency) || !precomputedGraph.containsKey(toCurrency)) {
            return NO_CONVERSION;
        }

        return precomputedGraph.get(fromCurrency).getOrDefault(toCurrency, NO_CONVERSION);
    }

    public static void main(String[] args) {
        List<String[]> rates = new ArrayList<>();
        rates.add(new String[] { "USD", "GBP", "0.77" });
        rates.add(new String[] { "GBP", "EUR", "1.15" });
        rates.add(new String[] { "USD", "CAD", "1.30" });

        // 使用 Floyd-Warshall 进行预计算
        Map<String, Map<String, Double>> precomputedGraph = precomputeRates(rates);

        // 进行汇率查询
        System.out.println("USD to EUR: " + queryConversionRate(precomputedGraph, "USD", "EUR")); // 输出应为 0.77 * 1.15 =
                                                                                                  // 0.8855
        System.out.println("GBP to CAD: " + queryConversionRate(precomputedGraph, "GBP", "CAD")); // 输出应为 1.0 / 0.77 *
                                                                                                  // 1.30
        System.out.println("EUR to CAD: " + queryConversionRate(precomputedGraph, "EUR", "CAD")); // 输出应为 -1.0
    }
}
