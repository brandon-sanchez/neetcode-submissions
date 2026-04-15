class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //Key: Count | Value: List of Numbers
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer>[] numberList = new List[nums.length + 1];


        for(int i=0; i < numberList.length; i++) {
            numberList[i] = new ArrayList<>();
        }

        for(int number : nums) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            numberList[entry.getValue()].add(entry.getKey());
        }

        int[] outputArray = new int[k];
        int index = 0;

        for(int i = numberList.length - 1; i > 0 && index < k; i--) {
            for(int n : numberList[i]) {
                outputArray[index++] = n;
                if(index == k) {
                    return outputArray;
                }
            }
        }

        return outputArray;
    }
}
