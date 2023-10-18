class Solution {
    public int search(int[] nums, int target) {
        // Initialize the left and right pointers to the start and end of the array.
        int left = 0;
        int right = nums.length - 1;

        // Perform a binary search.
        while (left <= right) {
            // Calculate the middle index of the current search range.
            int mid = left + (right - left) / 2;

            // Check if the element at the middle index is less than the target.
            if (nums[mid] < target) {
                // If it is, update the left pointer to mid + 1 to search the right subarray.
                left = mid + 1;
            } 
            // Check if the element at the middle index is greater than the target.
            else if (nums[mid] > target) {
                // If it is, update the right pointer to mid - 1 to search the left subarray.
                right = mid - 1;
            } 
            // If the element at the middle index is equal to the target, we have found the target.
            else {
                // Return the index of the target element.
                return mid;
            }
        }

        // If the target element is not found in the array, return -1.
        return -1;
    }
}
