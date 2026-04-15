class Solution {

    // This method encodes a list of strings into a single string
    public String encode(List<String> strs) {
        // Use StringBuilder for efficient string concatenation
        StringBuilder res = new StringBuilder();

        // For each string in the input list
        for(String str : strs) {
            // Append the length of the string, a special delimiter (#), and then the string itself
            // Example: "apple" becomes "5#apple"
            res.append(str.length()).append('#').append(str);
        }

        // Return the final encoded string
        // Example: ["apple", "banana"] -> "5#apple6#banana"
        return res.toString();
    }

    // This method decodes a single string back into a list of original strings
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0; // Pointer to track position in the encoded string

        // Loop through the entire string
        while (i < str.length()) {
            int j = i;

            // Find the position of the '#' delimiter
            // This tells us where the length of the string ends
            while (str.charAt(j) != '#') {
                j++;
            }

            // Extract the length of the upcoming string
            // Example: if str = "5#apple", then substring(0, 1) = "5" => length = 5
            int lengthOfString = Integer.parseInt(str.substring(i, j));

            // Move i to the start of the actual string (right after '#')
            i = j + 1;

            // j now points to the end of the actual string
            j = i + lengthOfString;

            // Extract the string using the length we just parsed
            // Example: substring(2, 7) = "apple"
            res.add(str.substring(i, j));

            // Move i to the next position to process the next encoded part
            i = j;
        }

        // Return the list of decoded strings
        return res;
    }
}
