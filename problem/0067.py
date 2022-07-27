class Solution:
    def addBinary(self, a: str, b: str) -> str:
        # method 1, loop to iterate, time = O(N), space = O(N)
        result, carry = "", 0
        i, j = len(a)- 1, len(b) - 1
        while i >= 0 or j >= 0:
            v1 = int(a[i]) if i >= 0 else 0 
            v2 = int(b[j]) if j >= 0 else 0 
            digit = v1 + v2 + carry
            carry = 1 if digit > 1 else 0
            digit %= 2
            result += str(digit)
            i -= 1
            j -= 1
        if carry == 1: result += "1"
        return result[::-1]