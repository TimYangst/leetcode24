class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        w = len(mat)
        h = len(mat[0])
        result = []
        for i in range(w + h - 1) :
            if i % 2 == 0:
                x = i if i < w else w - 1
                y = 0 if i < w else i - w + 1
                k = 0
                while x - k >= 0 and y + k < h:
                    result.append(mat[x - k][y + k])
                    k +=1
            else :
                x = 0 if i < h else i - h + 1 
                y = i if i < h else h - 1
                k = 0
                while x + k < w and y - k >= 0:
                    result.append(mat[x + k][y - k])
                    k += 1
        return result
                
        