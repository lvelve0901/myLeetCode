package test;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	public static int[] twoSum (int[] nums, int target) {
		boolean isFinish = false;
		int[] ret = new int[2];
		HashMap<Integer,Integer> myMap = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			myMap.put(nums[i], i);
		}
		for (int i=0; i<nums.length && isFinish == false; i++) {
			int complem = target - nums[i];
			if (myMap.containsKey(complem) == true && myMap.get(complem) != i) {
				ret[0] = i;
				ret[1] = myMap.get(complem);
				isFinish = true;
			}
		}
		return ret;
	}
	
	public static void main(String[] args){
		int[] nums = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums,target)));
	}
}
