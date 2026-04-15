class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
       result = defaultdict(list)

       for s in strs:
         sortedStrings = ''.join(sorted(s))
         result[sortedStrings].append(s)

       return result.values()