class Solution:
    def isValid(self, s: str) -> bool:
        
        myStack = []
        myHashMap = {'}' : '{', ']' : '[', ')' : '('}

        for char in s:
            if char in myHashMap:
                if myStack and myStack[-1] == myHashMap[char]:
                    myStack.pop()
                else:
                    return False
            else:
                myStack.append(char)
        
        if not myStack:
            return True
        else:
            return False
