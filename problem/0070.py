class Solution:
    def climbStairs(self, n: int) -> int:
        if n < 4: return n
        prevOfPrev, prev, current = 1, 2, 3
        while n > 2:
            current = prevOfPrev + prev
            prevOfPrev = prev
            prev = current
            n -= 1
        return current