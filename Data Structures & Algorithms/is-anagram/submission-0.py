class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        #check same number of characters in each
        if len(s) != len(t):
            return False
        
        #create has tables for each string
        countS = {}
        countT = {}

        #check for character matches
        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i],0)
            countT[t[i]] = 1 + countT.get(t[i],0)
        return countS == countT
        