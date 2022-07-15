class Solution:
    def firstUniqChar(self, s: str) -> int:
        # # method 1, letter count by self, time = O(N), space = O(1)
        # letterCount = defaultdict(lambda: 0);
        # for i in range(len(s)):
        #     letterCount[s[i]] += 1
        # for i in range(len(s)):
        #     if letterCount[s[i]] == 1:
        #         return i
        # return -1
        
        # method 2, letter count by tool, time = O(N), space = O(1)
        letterCount = collections.Counter(s)
        for index, letter in enumerate(s):
            if letterCount[letter] == 1:
                return index
        return -1
