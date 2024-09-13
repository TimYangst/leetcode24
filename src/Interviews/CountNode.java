import java.util.HashSet;
import java.util.Set;

class CountNode {
    static public class Node {
        // id of this node node
        private final int nodeId;
        // id's of all of the children of this node
        private Set<Integer> childrenIds = new HashSet<>();

        // null check
        // nodeId is valid
        // no duplicate node id
        public Node(int nodeId, Set<Integer> children) {
            this.nodeId = nodeId;
            this.childrenIds = children;
        }

        private boolean isMyChild(int nodeId) {
            return childrenIds.contains(nodeId);
        }

        public void sendAsync(int nodeId, String msg) {
        }

        private int totalNodeInSubtree = 0;
        private int parentNodeId = -1;
        private int currentReceivedCount = 0;
        final static String MSG_ACK_COUNT = "ack_count"; // ack_count:123
        final static String MSG_DO_COUNT = "do_count";
        final static String MSG_LEAF_NODE = "ack_count:1";

        // public doc
        //
        public void receive(int sourceNodeId, String msg) {
            if (isMyChild(sourceNodeId)) {
                if (!msg.startsWith(MSG_ACK_COUNT)) {
                    // bad thing happened, ignore msg
                    return;
                }
                String sub = msg.substring(MSG_ACK_COUNT.length() + 1);
                int ackCount = -1;
                try {
                    ackCount = Integer.parseInt(sub);
                } catch (Exception e) {
                    // logging
                    return;
                }
                totalNodeInSubtree += ackCount;
                // we use this to track how many msgs from children
                currentReceivedCount++;
                if (currentReceivedCount == this.childrenIds.size()) {
                    totalNodeInSubtree++;
                    this.sendAsync(this.parentNodeId, MSG_ACK_COUNT + ":" + totalNodeInSubtree);
                }
            } else {
                // msg is from parent
                if (!msg.startsWith(MSG_DO_COUNT)) {
                    // bad thing happened, ignore msg
                    return;
                }
                parentNodeId = sourceNodeId;
                if (childrenIds.size() == 0) {
                    totalNodeInSubtree = 1;
                    sendAsync(parentNodeId, MSG_ACK_COUNT + ":1");
                    return;
                }
                for (int chidlId : childrenIds) {
                    sendAsync(chidlId, MSG_DO_COUNT);
                }
            }
        }
    }

    /*
     * receive from parent - count
     * note down parent node ID
     * for each child node, we call sendAsync (id, count )
     * receive from child - ack node number -
     * sum += number
     * count += 1
     * once co‍‍‍‌‍‌‌‌‍‍‍‌‍‍‌‌‌‍‍‌unt is there, sendAsync to parent(id, ack sum)
     */
    public static void main(String[] args) {
        /*
         * ArrayList<String> strings = new ArrayList<String>();
         * strings.add("Hello, World!");
         * strings.add("Welcome to CoderPad.");
         * strings.add("This pad is running Java " + Runtime.version().feature());
         * for (String string : strings) {
         * System.out.println(string);
         * }
         */
    }
}
