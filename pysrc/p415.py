class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        chr1 = num1[::-1]
        chr2 = num2[::-1]
        result = []
        i = 0
        j = 0
        carry = 0
        current = 0
        while i < len(chr1) or j < len(chr2) or carry > 0:
            v1 = int(chr1[i]) if i < len(chr1) else 0
            v2 = int(chr2[j]) if j < len(chr2) else 0
            total = v1 + v2 + carry
            carry = total // 10
            result.append(str(total % 10))
            i+=1
            j+=1
        return "".join(result[::-1])
