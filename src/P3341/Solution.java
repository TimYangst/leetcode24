package P3341;

import java.util.Arrays;
import java.util.PriorityQueue;

class Room {
    int x;
    int y;
    int moveInTime;

    public Room(int x, int y, int moveInTime) {
        this.x = x;
        this.y = y;
        this.moveInTime = moveInTime;
    }
}

class Solution {
    int[] delta = { 0, 1, 0, -1, 0 };

    public int minTimeToReach(int[][] moveTime) {
        int[][] minReachTime = new int[moveTime.length][moveTime[0].length];
        int w = moveTime.length;
        int h = moveTime[0].length;
        for (int i = 0; i < w; i++) {
            Arrays.fill(minReachTime[i], -1);
        }
        PriorityQueue<Room> queue = new PriorityQueue<>((a, b) -> (a.moveInTime - b.moveInTime));
        queue.add(new Room(0, 0, 0));
        minReachTime[0][0] = 0;
        while (!queue.isEmpty()) {
            Room current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + delta[i];
                int ny = current.y + delta[i + 1];
                if (nx < 0 || nx >= w || ny < 0 || ny >= h)
                    continue;
                if (minReachTime[nx][ny] != -1)
                    continue;
                Room newRoom = new Room(nx, ny, Math.max(current.moveInTime, moveTime[nx][ny]) + 1);
                minReachTime[nx][ny] = newRoom.moveInTime;
                queue.add(newRoom);
            }
            if (minReachTime[w - 1][h - 1] != -1)
                break;
        }
        return minReachTime[w - 1][h - 1];
    }
}