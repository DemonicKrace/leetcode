class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # method 1, sort and two pointer, time = O(N^2), space = O(N)
        result = []
        nums.sort()
        n = len(nums)
        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i - 1]: continue
            j, k = i + 1, n - 1
            while j < k:
                if nums[j] + nums[k] > -nums[i]: k -= 1
                elif nums[j] + nums[k] < -nums[i]: j += 1
                else:
                    result.append([nums[i], nums[j], nums[k]])
                    k -= 1
                    j += 1
                    while j < k and nums[j] == nums[j - 1]: j += 1
                    while j < k and nums[k] == nums[k + 1]: k -= 1
        return result