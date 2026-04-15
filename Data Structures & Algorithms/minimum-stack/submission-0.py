class MinStack:

    def __init__(self):
        # initialize both stacks
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        # Add value to normal stack
        self.stack.append(val)
        
        # if minStack is not empty, val is replaced by min of end of stack or previous value
        if self.minStack:
            val = min(val, self.minStack[-1])
        # else val is just compared against itself
        else:
            val = min(val, val)
        
        # Add value to min stack
        self.minStack.append(val)

    def pop(self) -> None:
        # pop both stacks
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        # Show top of only normal stack
        return self.stack[-1]

    def getMin(self) -> int:
        # Show top of minStack since top will always be the minimum number
        return self.minStack[-1]
                