class Solution:
    def isValidPalindrome(self, s: str, k: int) -> bool:
        f = [[0] * (len(s)) for _ in range(len(s))]
        l = len(s)
        for i in range(l - 1) :
            if s[i] != s[i+1]:
                f[i][i+1] = 1
        for i in range(2, l):
            for j in range(0, l - i):
                if s[j] == s[j + i]:
                    f[j][j+i] = f[j+1][j+i-1]
                else:
                    f[j][j+i] = min(f[j][j+i-1], f[j+1][j+i]) + 1
        print(f[0])
        return f[0][l-1] <= k


        