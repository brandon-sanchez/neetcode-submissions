public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> hashmap = new HashMap<>();
        hashmap.put(')', '(');
        hashmap.put(']', '[');
        hashmap.put('}', '{');

        for (char c : s.toCharArray()) {
            if (hashmap.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == hashmap.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
