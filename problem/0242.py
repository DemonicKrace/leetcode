class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # method 1, use tool to count letter
        return collections.Counter(s) == collections.Counter(t)
