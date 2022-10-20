package Array;

/*
 * ArrayOperation class contains 4 methods named - 
 * 1. largestMirror
 * 2. clumpCounter
 * 3. fixXy
 */


public class ArrayOperations {
	
	/*
	 * largestMirror method takes one argument an array and returns the maximum subarray size
	 * having a mirror subarray available
	 * @param int[] nums is the only argument
	 * @returns the maximum subarray size whose mirror subarray exist in the same array
	 */
	
	public int largestMirror(int[] nums) {
		if(nums.length == 0)
			throw new AssertionError("Enter a valid Array");
		int len = nums.length;
		int count= 0;
		int max = 0;
		for(int i = 0; i < len; i++){
			count=0;
			
		    for (int j = len-1; i + count < len && j > -1; j--){
		    	
		    	if(nums[i+count] == nums[j])
		      	{
		    		count++;
		      	}
		    	else
		    	{
			        if (count > 0)
			        {
			        	max = Math.max(count,max);
			        	count = 0;
			        }
		    	}
		    }
		    max = Math.max(count,max);
		  }
		  return max;
		}
	
	/*
	 * clumpCounter method takes one argument an array and returns the number of clump in an array
	 * Clump in an array is a series of 2 or more adjacent elements of the same value.
	 * For example - 
	 * 
	 * countClumps([1, 2, 2, 3, 4, 4])  - 2
	 * countClumps([1, 1, 2, 1, 1]) - 2
	 * countClumps([1, 1, 1, 1, 1]) - 1
	 * 
	 * @param int[] nums is the only argument 
	 * @returns the number of clump found in the array
	 */
	
	public int clumpCounter(int[] nums) 
	{
		if(nums.length == 0)
			throw new AssertionError("Enter a valid Array");
		boolean match = false;
		int count = 0;
		for (int i = 0; i < nums.length-1; i++) 
		{
		    if (nums[i] == nums[i+1] && !match) 
		    {
		      match = true;
		      count++;
		    } 
		    else if (nums[i] != nums[i+1]) 
		    {
		      match = false;
		    }
		}
		  return count;
	}
	
	/*
	 * fixXy methods takes one argument an array and return an array that contains exactly 
	 * the same numbers as the input array, but rearranged so that every X is immediately followed by a Y.
	 * @param int[] nums is the only argument
	 * @returns returns an array that contains exactly 
	 * the same numbers as the input array, but rearranged so that every X is immediately followed by a Y.
	 */
	
	public int[] fixXY(int[] nums, int x, int y) 
	{
		if(nums.length == 0)
			throw new AssertionError("Enter a valid Array");
		
		if(nums[nums.length-1] == x)
			throw new AssertionError("You cannot Enter a "+x+" at the end of the array.");
		
		int countx = 0;
		int county = 0;
		for(int ele : nums)
		{
			if(ele == x)
			{
				countx++;
			}else if (ele == y) {
				county++;
			}
		}
		
		if(countx != county)
			throw new AssertionError("Number of "+x+" should be equal to number of "+y);
		
		for (int i = 0; i < nums.length; i++) 
		{
			if (nums[i] == x) 
			{
				for (int j = 0; j < nums.length; j++) 
				{
					if (nums[j] == y) 
					{
						if (j > 0 && nums[j-1] != x) 
						{
				            int tmp = nums[i+1];
				            nums[i+1] = y;
				            nums[j] = tmp;
						} 
						else if (j == 0)
						{
				            int tmp = nums[i+1];
				            nums[i+1] = y;
				            nums[j] = tmp;
						}
		                     
					}
				}
		   	}
		}
			return nums;
	}
	
	/*
	 * splitArray methods takes one argument an array and return the index at which the array can be split 
	 * such that the sum of both halves is equal
	 * @param int[] nums is the only argument
	 * @returns return the index at which the array can be split 
	 * such that the sum of both halves is equal immediately followed by a Y.
	 */
	

	public int splitArray(int[] userArr) {
        if(userArr.length == 0) {
                throw new AssertionError("Given Array is Empty");
        }
        int arraySum = 0;
        for(int iterator = 0; iterator < userArr.length; iterator++) {
                arraySum += userArr[iterator];
        }
        if(arraySum%2 == 0) {
                int splitSum = 0, pointer = 0;
                while(splitSum != arraySum/2) {
                        if(pointer == userArr.length-1) {
                                return -1;
                        }
                        splitSum += userArr[pointer];
                        pointer++;
                        
                }
                return pointer;
        }
        else {
                return -1;
        }
}
	
}
