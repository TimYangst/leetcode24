package Top150.P380InsertDeleteGetRandomO1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    Map<Integer, Integer> dataIndexs;
    int[] data;
    final static int MAX_ACTIONS = 200000;
    Random random;

    public RandomizedSet() {
        dataIndexs = new HashMap<>();
        data = new int[MAX_ACTIONS + 1];
        random = new Random(System.currentTimeMillis());
    }
    
    public boolean insert(int val) {
        if (dataIndexs.containsKey(val)) return false;
        data[0]++;
        data[data[0]] = val;
        dataIndexs.put(val, data[0]);
        return true;
    }
    
    public boolean remove(int val) {
        if (dataIndexs.containsKey(val)) {
            int index = dataIndexs.get(val);
            dataIndexs.remove(val);
            if (index == data[0]) {
                data[0] --;
            } else {
                data[index] = data[data[0]];
                data[0] --;
                dataIndexs.put(data[index], index);
            }
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(data[0]) + 1;
        return data[randomIndex];
    }
}
