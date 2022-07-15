class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        result = 0
        isPostive = True
        isAfterFirstRound = False
        for i in range(len(s)):
            if s[i] == '-' or s[i] == '+':
                if isAfterFirstRound: break
                if s[i] == '-': isPostive = False
            elif s[i].isdigit():
                digit = ord(s[i]) - ord('0')
                result = result * 10 + digit 
                # python integer is 64-bits
                # check number is between -2^31 ~ 2^31-1
                if (isPostive and result > 2 ** 31 - 1) or (not isPostive and result > 2 ** 31):
                    return 2 ** 31 - 1 if isPostive else -2 ** 31
            else: break
            if not isAfterFirstRound: isAfterFirstRound = True
        return result if isPostive else -result
