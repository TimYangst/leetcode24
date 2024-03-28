package P399EvaluateDivision;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> indexing = new HashMap<>();
        int total = 0;
        for (int i = 0; i< equations.size(); i++ ){
            for (String item : equations.get(i)) {
                if (!indexing.containsKey(item)) {
                    indexing.put(item, total);
                    total++;
                }
            }
        }
        double[][] square = new double[total][total];
        int k=0;
        for (int i = 0; i< equations.size(); i++ ){
            square[indexing.get(equations.get(i).get(0))][indexing.get(equations.get(i).get(1))] = values[k];
            k++;
        }
        for (int i = 0; i< total; i++) {
            square[i][i] = 1.0;
            for (int j = 0; j < i; j ++) {
                if (square[i][j] != 0) square[j][i] = 1.0/square[i][j];
                else if (square[j][i] != 0) square[i][j] = 1.0/square[j][i];
            }
        }
        for (k = 0; k < total; k++) {
            for (int i = 0; i< total; i++) {
                for (int j = 0; j< total; j++) {
                    if (square[i][j] == 0) {
                        if (square[i][k] != 0 && square[k][j] != 0) {
                            square[i][j] = square[i][k] * square[k][j];
                        }
                    }
                }
            }
        }
        double[] result = new double[queries.size()];
        k = 0;
        for (int i = 0; i < queries.size(); i++) {
            if (!indexing.containsKey(queries.get(i).get(0)) || !indexing.containsKey(queries.get(i).get(1))) {
                result[k] = -1;
            } else {
                result[k] = square[indexing.get(queries.get(i).get(0))][indexing.get(queries.get(i).get(1))];
                if (result[k] == 0) {
                    result[k] = -1;
                }
            }
            k++;
        }
        return result;
    }
}