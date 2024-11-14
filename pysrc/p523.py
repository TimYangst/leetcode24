class Solution:
    # def getPosMod(self, value: int, k: int) -> int:
    #     value = value % k
    #     if value < 0:
    #         value += k
    #     return value
 
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        if len(nums) < 2 :
            return False
        s = nums[0] % k
        dicts = {}
        dicts[s] = 0
        for i in range(1, len(nums)) :
            s = (s + nums[i]) % k
            if s == 0:
                return True
            if dicts.get(s, -1) != -1:
                if i - dicts.get(s, -1) > 1:
                    return True
            else :
                dicts[s] = i
        return False

        