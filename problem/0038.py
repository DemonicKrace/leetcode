class Solution:
    def countAndSay(self, n: int) -> str:
        # # method 1, recursive, time = O(N^2), space = O(N)
        # def say(text: str):
        #     result = ""
        #     count = 1
        #     for i in range(1, len(text)):
        #         if text[i] == text[i - 1]:
        #             count += 1
        #         else:
        #             result += f"{count}{text[i - 1]}"
        #             count = 1
        #     result += f"{count}{text[-1]}"
        #     return result
        # if n == 1: return "1"
        # return say(self.countAndSay(n - 1))
        
        # https://leetcode.com/problems/count-and-say/discuss/15999/4-5-lines-Python-solutions
        # method 2, use groupby, time = O(N^2logN), space = O(N)
        result = "1"
        for _ in range(n - 1):
            result = ''.join(str(len(list(group))) + key for key, group in itertools.groupby(result))
        return result
