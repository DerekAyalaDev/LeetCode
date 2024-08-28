class Solution:
  def minPatches(self, nums: List[int], n: int) -> int:
    """
    Calculate the minimum number of patches required to ensure that every
    integer from 1 to n can be represented as a sum of elements in the array nums.

    Args:
        nums (List[int]): A sorted list of positive integers representing the current array.
        n (int): The target number up to which every integer should be covered.

    Returns:
        int: The minimum number of patches needed.
    """
    result = 0 # To keep track of the number of patches needed
    maxCovered = 0 # The maximum value that can be covered with the current array
    index = 0 # Index to iterate through the nums array

    # Continue until we have covered all values up to n
    while(maxCovered < n):
      # If the current index is within bounds and the current number is <= maxCovered + 1
      if(index < len(nums) and nums[index] <= maxCovered + 1):
        # Extend the range of covered values by including nums[index]
        maxCovered += nums[index]
        index+=1 # Move to the next number in the array
      else:
        # If we can't cover maxCovered + 1, we need to add a patch
        patch = maxCovered + 1 # The value of the patch we need to add
        maxCovered += patch # Extend the range of covered values by including the patch
        result+=1 # Increment the patch count
    # Return the total number of patches needed
    return result