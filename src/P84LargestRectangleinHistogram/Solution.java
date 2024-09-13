package P84LargestRectangleinHistogram;

import java.util.Stack;

class Solution {

    class Element {
        int height;
        int index;

        public Element(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];
        int result = heights[0];
        Stack<Element> stack = new Stack<Element>();
        stack.push(new Element(heights[0], 0));
        for (int i = 1; i < heights.length; i++) {
            result = Math.max(result, heights[i]);
            Element current = new Element(heights[i], i);
            while (!stack.isEmpty() && heights[i] <= stack.peek().height) {
                Element top = stack.pop();
                result = Math.max(result, top.height * (i - top.index));
                current.index = top.index;
            }
            stack.push(current);
        }
        while (!stack.isEmpty()) {
            Element current = stack.pop();
            result = Math.max(result, current.height * (heights.length - current.index));
        }
        return result;
    }
}