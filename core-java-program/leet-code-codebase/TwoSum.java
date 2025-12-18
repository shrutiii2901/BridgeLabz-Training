import java.util.HashMap;
import java.util.Map;

class Main {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store: value -> index
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the required complement is already in our map
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            
            // Otherwise, add current number and its index to the map
            numMap.put(nums[i], i);
        }
        
        // Return an empty array or throw exception if no solution is found
        throw new IllegalArgumentException("No two sum solution");
    }
}