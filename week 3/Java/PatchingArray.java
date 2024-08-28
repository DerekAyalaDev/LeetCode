class PatchingArray {
  /**
   * Calculates the minimum number of patches required to cover all numbers
   * from 1 to `n` using the given sorted array `nums`.
   *
   * A patch is a number that can be added to the array `nums` to extend the
   * range of numbers that can be formed by summing the elements of `nums`.
   *
   * @param nums An array of positive integers, sorted in non-decreasing order.
   * @param n    The maximum number to be covered.
   * @return The minimum number of patches required to cover all numbers from 1 to
   *         `n`.
   */
  public int minPatches(int[] nums, int n) {
    int result = 0; // To keep track of the number of patches needed
    long maxCovered = 0; // The maximum value that can be covered with the current array
    int index = 0; // Index to iterate through the nums array

    // Continue until we have covered all values up to n
    while (maxCovered < n) {
      // If the current index is within bounds and the current number is <= maxCovered
      // + 1
      if (index < nums.length && nums[index] <= maxCovered + 1) {
        // Extend the range of covered values by including nums[index]
        maxCovered += nums[index];
        index++; // Move to the next number in the array
      } else {
        // If we can't cover maxCovered + 1, we need to add a patch
        long patch = maxCovered + 1; // The value of the patch we need to add
        maxCovered += patch; // Extend the range of covered values by including the patch
        result++; // Increment the patch count
      }
    }

    // Return the total number of patches needed
    return result;
  }
}
