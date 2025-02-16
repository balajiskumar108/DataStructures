package EECS;

public class Recursion {

    /**
     * Checks if an array can be split into two subarrays with equal sums.
     *
     * @param nums The array of integers.
     * @return true if the array can be split, false otherwise.
     */
    public boolean splitArray(int[] nums) {
        return splitHelper(nums, 0, 0, 0);
    }

    /**
     * Recursive helper function for splitArray.
     *
     * @param nums  The array of integers.
     * @param index The current index in the array.
     * @param s1    The sum of the first subarray.
     * @param s2    The sum of the second subarray.
     * @return true if the array can be split, false otherwise.
     */
    private boolean splitHelper(int[] nums, int index, int s1, int s2) {
        // Base case: If the end of the array is reached
        if (index == nums.length) {
            return s1 == s2;
        }

        // Recursive case: Try adding the current element to either subarray
        return splitHelper(nums, index + 1, s1 + nums[index], s2) ||
               splitHelper(nums, index + 1, s1, s2 + nums[index]);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();

        // Test case 1: Array can be split into two subarrays with equal sums
        int[] nums1 = {2, 2};
        System.out.println("Test case 1: " + recursion.splitArray(nums1)); // Expected: true

        // Test case 2: Array cannot be split into two subarrays with equal sums
        int[] nums2 = {1, 2, 3};
        System.out.println("Test case 2: " + recursion.splitArray(nums2)); // Expected: false

        // Test case 3: Array can be split into two subarrays with equal sums
        int[] nums3 = {1, 5, 11, 5};
        System.out.println("Test case 3: " + recursion.splitArray(nums3)); // Expected: true

        // Test case 4: Empty array (edge case)
        int[] nums4 = {};
        System.out.println("Test case 4: " + recursion.splitArray(nums4)); // Expected: true

        // Test case 5: Single element array (cannot split)
        int[] nums5 = {4};
        System.out.println("Test case 5: " + recursion.splitArray(nums5)); // Expected: false
    }
}
