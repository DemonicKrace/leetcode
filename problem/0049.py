class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # method 1, sorted letters as key to store strings, time = O(N * KlogK), space = O(N), K = characters size
        group = dict()
        for word in strs:
            key = ''.join(sorted(word))
            group[key] = group.get(key, []) + [word]
        return group.values()
