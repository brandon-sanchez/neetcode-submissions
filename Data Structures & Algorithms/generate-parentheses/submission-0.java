class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();

        backtrack(0,0,n,result,stack);
        return result;
    }

    public void backtrack(int openN, int closedN, int n, List<String> result, StringBuilder stack) {

        /**
        If the number of open and closed parethesis are the same AND the number of open parenthesis is equal to n
        add the string to the list of results in the ArrayList

        Valid: if and only if open == closed == n
        **/
        if(openN == closedN && openN == n) {
            result.add(stack.toString());
            return;
        }

        /**
        Only add open parenthesis if open < n

        -add open parenthesis to string
        -recursively backtrack only updating the count of open by 1 (the rest stay the same)
        -delete the the character at the end of the string

        **/
        if(openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        /**
        Only add open parenthesis if closed < open

        -add closed parenthesis to string
        -recursively backtrack only updating the count of closed by 1 (the rest stay the same)
        -delete the the character at the end of the string

        **/
        if(closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }


}
