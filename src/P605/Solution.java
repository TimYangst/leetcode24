package P605;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int last = 0;
        int emptySpot = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                last = 1;
            } else {
                if (last == 0) {
                    if (i + 1 < flowerbed.length && flowerbed[i + 1] == 0 || i + 1 == flowerbed.length) {
                        emptySpot += 1;
                        last = 1;
                    }
                } else {
                    last = 0;
                }
            }
        }
        return emptySpot >= n;
    }
}
