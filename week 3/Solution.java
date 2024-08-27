import java.util.ArrayList;
import java.util.List;

class Solution {

  /**
   * Main Method to generate all possible permutations of the given array of integers
   * @param nums The array of integers to permute.
   * @return a List of lists, where each inner list is a posible permutation the array
   */
  public List<List<Integer>> permute(int[] nums) {
    // List to store all the permutations
    List<List<Integer>> result = new ArrayList<>();

    // Start the recursive generation of permutations
    generatePermutations(nums, nums.length, result);

    // Return the list of all permutations
    return result;
  }

  /**
   * Recursive method that generates all permutations of the array using Heap's algorithm
   * @param nums The array of integers to permute.
   * @param size The current size of the subset to permute.
   * @param result The list where all permutations are stored.
   */
  private void generatePermutations(int[] nums, int size, List<List<Integer>> result) {
    // Base case: If the size of the subset is 1, add the current permutation to the result
    if (size == 1) {
      // Create a new list to store the current permutation
      List<Integer> permutation = new ArrayList<>();

      // Add each elemnt from the array
      for (int num : nums) {
        permutation.add(num);
      }

      // Add the current permutation to the result list.
      result.add(permutation);
    } else {
      // Recursively generate permutations for size - 1
      for (int i = 0; i < size; i++) {
        generatePermutations(nums, size - 1, result);

        // Determine whether to swap the first or i-th element with the last element
        // Based on the whether the current size is even or odd
        if (size % 2 == 0) {
          // If the size is even, swap the i-th element with the last element
          swap(nums, i, size - 1);
        } else {
          // If the size is odd, swap the first element with the last element
          swap(nums, 0, size - 1);
        }
      }
    }
  }

  /**
   * Helper method to swap two elements in the array.
   * @param nums The array in which to swap elements.
   * @param i The index of the first element to swap.
   * @param j The index of the second element to swap
   */
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    Solution pg = new Solution();
    int[] nums = { 1, 2, 3, 4 };
    List<List<Integer>> permutations = pg.permute(nums);
    for (List<Integer> permutation : permutations) {
      System.out.println(permutation);
    }
  }
}