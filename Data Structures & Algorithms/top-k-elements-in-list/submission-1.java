class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //Key: Number, Value: Count
        HashMap<Integer, Integer> map = new HashMap<>();
        

        //Array of Arraylists: index will be the amount of times it appears,
        //list will contain the numbers there
        List<Integer>[] array = new List[nums.length + 1];

        //the array we are returning with k elements
        int[] result = new int[k];

        for(int i = 0; i < array.length; i++) {
            array[i] = new ArrayList<Integer>();
        }

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = array[entry.getValue()];
            list.add(entry.getKey());
        }

        int resultIndex = 0;
        for(int i = array.length - 1; i > 0 && resultIndex < k; i--) {
            //for every number in the list
            for(int n : array[i]) {
                result[resultIndex++] = n;
                if(resultIndex == k) {
                    return result;
                }
            }
        }

        return result;


    }
}
