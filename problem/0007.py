class Solution:
    def reverse(self, x: int) -> int:
        # # python3 number is 64-bits
        # # method 1
        # isPostive = x >= 0
        # x = abs(x)
        # result = 0
        # while x != 0:
        #     pop = x % 10
        #     result = result * 10 + pop
        #     # check range
        #     if (isPostive and result > 2 ** 31 - 1) or (not isPostive and result > 2 ** 31):
        #         return 0
        #     x = x // 10
        # return result if isPostive else -result
        
        # method 2, reverse as string
        reverse = int(str(x * -1)[::-1]) * -1 if x < 0 else int(str(x)[::-1])
        return 0 if (reverse > 2 ** 31 - 1 or reverse < -2 ** 31) else reverse
