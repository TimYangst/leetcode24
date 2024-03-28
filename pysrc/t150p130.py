from typing import List


class Solution:
    __dx = [0, 1, 0 , -1]
    __dy = [1, 0, -1, 0] 
    m = 0
    n = 0

    def getNext(self, current):
        result = []
        for i in range(4):
            if (0 <= current[0] + self.__dx[i] and current[0] + self.__dx[i] < self.m
                and 0 <= current[1] + self.__dy[i] and current[1] + self.__dy[i] < self.n):
                result.append((current[0] + self.__dx[i], current[1] + self.__dy[i]))
        return result

    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.m = len(board)
        self.n = len(board[0])
        if (self.m < 3 or self.n < 3) :
            return
        queue = []
        for i in range(self.m):
            if (board[i][0] ==  "O"):
                board[i][0] = "V"
                queue.append((i, 0),)
            if (board[i][self.n-1] == "O"):
                board[i][self.n-1] = "V"
                queue.append((i, self.n-1),)
        for j in range(self.n):
            if (board[0][j] == "O"):
                board[0][j] = "V"
                queue.append((0, j),)
            if (board[self.m-1][j] == "O"):
                board[self.m-1][j] = "V"
                queue.append((self.m-1, j),)
        while (len(queue) > 0): 
            coord = queue.pop(0)
            for next in self.getNext(coord):
                if board[next[0]][next[1]] == "O":
                    board[next[0]][next[1]] = "V"
                    queue.append((next[0], next[1]),)
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == "V":
                    board[i][j] = "O"
                elif board[i][j] == "O":
                    board[i][j] = "X"
        





        