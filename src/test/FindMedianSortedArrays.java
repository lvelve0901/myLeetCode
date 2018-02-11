package test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindMedianSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0.0;
		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] shorts = {};
		int[] longs = {};
		if (len1 >= len2) {
			longs = nums1;
			shorts = nums2;
		}
		else {
			longs = nums2;
			shorts = nums1;
		}
		
		//basic case: short array is empty
		if (shorts.length == 0) return getMedianValue(longs);
		
		//basic case: short array has only one element
		if (shorts.length == 1) {
			int len = longs.length;
			if (shorts.length == longs.length) return (shorts[0]+longs[0])/2.;
			if (shorts[0] < longs[0]) {
				return getMedianValue(Arrays.copyOfRange(longs, 0, len-1));
			}
			else if (shorts[0] > longs[len-1]) {
				return getMedianValue(Arrays.copyOfRange(longs, 1, len));
			}
			else {
				return insertOneMedian(longs,shorts[0]);
			}
		}
		
		//basic case: short array has two elements
		if (shorts.length%2 == 0 & longs.length%2 == 0) {
			if (shorts[shorts.length/2-1] > longs[longs.length/2-1] & shorts[shorts.length/2] < longs[longs.length/2]) {
				return (shorts[shorts.length/2-1] + shorts[shorts.length/2]) / 2.;
			}
			else if (shorts[shorts.length/2-1] < longs[longs.length/2-1] & shorts[shorts.length/2] > longs[longs.length/2]) {
				return (longs[longs.length/2-1] + longs[longs.length/2]) / 2.;
			}
				
		}
		
		//do recursion
		double shortsmed = getMedianValue(shorts);
		double longsmed = getMedianValue(longs);
		if (shortsmed > longsmed) {
			int[] newshorts = cutBackward(shorts,shorts.length/2);
			int[] newlongs = cutForward(longs,shorts.length/2);
			median = findMedianSortedArrays(newshorts, newlongs);
		}
		else if (shortsmed < longsmed) {
			int[] newshorts = cutForward(shorts,shorts.length/2);
			int[] newlongs = cutBackward(longs,shorts.length/2);
			median = findMedianSortedArrays(newshorts, newlongs);
		}
		else return shortsmed;
		
		return median;
    }
	
	public static double insertOneMedian(int[] nums, int num) {
		double newmedian = 0.0;
		int len = nums.length;
		double median = getMedianValue(nums);
		if (len%2 == 0) {
			if (num == median) newmedian = median;
			else if (num > median & num < nums[len/2]) newmedian = num;
			else if (num >= nums[len/2]) newmedian = nums[len/2];
			else if (num < median & num > nums[len/2-1]) newmedian = num;
			else if (num <= nums[len/2-1]) newmedian = nums[len/2-1];
		}
		else if (len%2 == 1) {
			if (num == median) newmedian = median;
			else if (num > median & num < nums[len/2+1]) newmedian = (num+nums[len/2])/2.;
			else if (num >= nums[len/2]) newmedian = (nums[len/2]+nums[len/2+1])/2.;
			else if (num < median & num > nums[len/2-1]) newmedian = (num+nums[len/2])/2.;
			else if (num <= nums[len/2-1]) newmedian = (nums[len/2]+nums[len/2-1])/2.;
		}
		return newmedian;
	}
	
	public static double getMedianValue(int[] nums) {
		double median = 0.0;
		int len = nums.length;
		if (len%2 == 0) median = (nums[len/2-1]+nums[len/2]) / 2.;
		else if (len%2 == 1) median = nums[len/2];
		return median;
	}
	
	public static int[] cutForward(int[] nums, int cutlen) {
		int len = nums.length;
		int[] copynums = {};
		copynums = Arrays.copyOfRange(nums, cutlen, len);
		return copynums;
	}
	
	public static int[] cutBackward(int[] nums, int cutlen) {
		int len = nums.length;
		int[] copynums = {};
		copynums = Arrays.copyOfRange(nums, 0, len-cutlen);
		return copynums;
	}
	
//	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        double median = 0.0;
//        int[] nums = new int[nums1.length + nums2.length];
//        System.arraycopy(nums1, 0, nums, 0, nums1.length);
//        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
//        Arrays.sort(nums);
//        if (nums.length%2 == 0) median = (nums[nums.length/2-1] + nums[nums.length/2]) /2.;
//        else if (nums.length%2 == 1) median = nums[nums.length/2];
//        return median;
//    }
	
	public static void main(String[] args){
		int[] a = {1,2,6};
		int[] b = {3,4,5};
		//int[] a = {1,2,3,5,8,10,12,13,14};
		//int[] b = {2,3,4,5};
		double ret = findMedianSortedArrays(a,b);
		System.out.println(ret);
		
	}
}
