package P11ContainerWithMostWater;

class SolutionWrong {
    class BinaryTree {
        int maxValue;
        int[] data;

        BinaryTree(int length) {
            maxValue = length;
            data = new int[2 * maxValue + 2];
            for (int i = 0; i < data.length; i++) {
                data[i] = -1;
            }
        }

        void insert(int height, int value, boolean isMin) {
            int b = 0, e = maxValue;
            insert(1, b, e, 0, height, value, isMin);
        }

        void insert(int index, int b, int e, int b1, int e1, int value, boolean isMin) {
            System.out.println(
                    String.format("index:%s, b:%s, e:%s, value:%s, b1: %s, e1:%s", index, b, e, value, b1, e1));
            if (e < b1 || b > e1)
                return;
            if (b1 <= b && e <= e1) {
                if (data[index] == -1) {
                    data[index] = value;
                }
                return;
            }
            int m = (b + e) / 2;
            insert(index * 2, b, m, b1, e1, value, isMin);
            insert(index * 2 + 1, m + 1, e, b1, e1, value, isMin);
            if (data[index * 2] != -1 && data[index * 2 + 1] != -1) {
                if (isMin) {
                    data[index] = Math.max(data[index * 2], data[index * 2 + 1]);
                } else {
                    data[index] = Math.min(data[index * 2], data[index * 2 + 1]);
                }
            }
        }

        int lookup(int height, boolean isMin) {
            int b = 0, e = maxValue;
            return lookup(1, b, e, 0, height, isMin);
        }

        int lookup(int index, int b, int e, int b1, int e1, boolean isMin) {
            if (b1 > e || e1 < b)
                return -1;
            if (b1 <= b && e <= e1)
                return data[index];
            int m = (b + e) / 2;
            if (m < b1) {
                return lookup(index * 2 + 1, m + 1, e, b1, e1, isMin);
            }
            if (m + 1 > e1) {
                return lookup(index * 2, b, m, b1, e1, isMin);
            }
            int lr = lookup(index * 2, b, m, b1, e1, isMin);
            int rr = lookup(index * 2 + 1, m + 1, e, b1, e1, isMin);
            if (lr == -1 || rr == -1)
                return -1;
            if (isMin) {
                return Math.max(lr, rr);
            } else {
                return Math.min(lr, rr);
            }
        }
    }

    public int maxArea(int[] height) {
        if (height.length <= 1)
            return 0;
        int maxH = 0;
        for (int i = 0; i < height.length; i++) {
            maxH = Math.max(height[i], maxH);
        }
        if (maxH == 0)
            return 0;
        BinaryTree bt1 = new BinaryTree(maxH);
        bt1.insert(height[0], 0, true);
        int result = 0;
        for (int i = 1; i < height.length; i++) {
            int li = bt1.lookup(height[i], true);
            if (li != -1) {
                result = Math.max(result, (i - li) * height[i]);
            }
            System.out.println(String.format("index:%s, hight: %s, li: %s, lh: %s", i, height[i], li,
                    (li == -1) ? -1 : height[li]));
            bt1.insert(height[i], i, true);
        }
        BinaryTree bt2 = new BinaryTree(maxH);
        bt2.insert(height[height.length - 1], height.length - 1, false);
        for (int i = height.length - 2; i >= 0; i--) {
            int ri = bt2.lookup(height[i], false);
            if (ri != -1) {
                result = Math.max(result, (ri - i) * height[i]);
            }
            System.out.println(String.format("index:%s, hight: %s, ri: %s, rh: %s", i, height[i], ri,
                    (ri == -1) ? -1 : height[ri]));
            bt2.insert(height[i], i, false);
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionWrong solution = new SolutionWrong();
        System.out.println(solution.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }
}