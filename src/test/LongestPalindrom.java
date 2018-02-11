package test;

import java.util.Arrays;

public class LongestPalindrom {
	/*
	 * center method
	 */
	
//	public static String longestPalindrome(String s) {
//        int maxlen = 0;
//        int start = 0, end = 0;
//		for (int i=0; i < s.length(); i++) {
//			int len1 = 0, len2 = 0;
//			len1 = findMaxPanCenter(s,i,i);
//			if (i+1 < s.length()) {
//				len2 = findMaxPanCenter(s,i,i+1);
//			}
//			if ((Math.max(len1, len2)) > maxlen) {
//				maxlen = Math.max(len1, len2);
//				if (len1 > len2) {
//					start = i - maxlen/2;
//					end = i + maxlen/2;
//				}
//				else {
//					start = i - maxlen/2 + 1;
//					end = i + maxlen/2;
//				}
//			}
//		}
//        return s.substring(start, end+1);
//    }
//	
//	public static int findMaxPanCenter(String s, int i, int j) {
//		if (s.charAt(i) != s.charAt(j)) {
//			return 0;
//		}
//		int left=0, right = 0;
//		while((i-left-1 >= 0) & (j+right+1 < s.length())) {
//			if (s.charAt(i-left-1) == s.charAt(j+right+1)) {
//				left = left + 1;
//				right = right + 1;
//			}
//			else break;
//		}
//		return (j+right) - (i-left) + 1;
//	}
	
	/*
	 * dynamic programming
	 */	
	
//	public static String longestPalindrome(String s) {
//		int maxlen = 0;
//		int start = 0, end = 0;
//		int[] ret = new int[4];
//		ret = numPalindrome(s,0,s.length()-1);
//		System.out.println(ret[0]);
//		System.out.println(ret[1]);
//		System.out.println(ret[2]);
//		System.out.println(ret[3]);
//		return s.substring(ret[2], ret[3]+1);
//
//	}
//	
//	public static int[] max_compare(int[] a, int[] b) {
//		if (a[0] == 0 & b[0] == 0) return new int[] {0,0,a[0],a[0]};
//		else if (a[0] > b[0]) return a;
//		else if (a[0] < b[0]) return b;
//		else {
//			if (a[1] >= b[1] ) return a;
//			else return b;
//		}
//	}
//	
//	public static int[] numPalindrome(String s, int i, int j) {
//		int[] ret = new int[4];
//		if ((i > j) | (i < 0) | (j > s.length())) return new int[] {0,0,i,j};
//		if (i == j) return new int[] {1,1,i,j};
//		if ((j == i+1) & (s.charAt(i) == s.charAt(j))) return new int[] {1,2,i,j};
//		if ((j == i+1) & (s.charAt(i) != s.charAt(j))) return new int[] {0,0,i,j};
//		if (s.charAt(i) == s.charAt(j)) {
//			if (numPalindrome(s,i+1,j-1)[0] == 1) return new int[] {numPalindrome(s,i+1,j-1)[0],numPalindrome(s,i+1,j-1)[1]+2,numPalindrome(s,i+1,j-1)[2]-1,numPalindrome(s,i+1,j-1)[3]+1};
//			else return max_compare(numPalindrome(s,i+1,j), numPalindrome(s,i,j-1));
//		}
//		else return max_compare(numPalindrome(s,i+1,j), numPalindrome(s,i,j-1));
//		
//	}
	
public static String longestPalindrome(String s) {
	int maxlen = 0;
	int start = 0, end = 0;
	boolean ret;
	ret = numPalindrome(s,0,s.length()-1);
	System.out.println(ret);
	return "";


}


public static boolean numPalindrome(String s, int i, int j) {
	int[] ret = new int[4];
	if ((i > j) | (i < 0) | (j > s.length())) return false;
	if (i == j) return true;
	if ((j == i+1) & (s.charAt(i) == s.charAt(j))) return true;
	if ((j == i+1) & (s.charAt(i) != s.charAt(j))) return false;
	return numPalindrome(s,i+1,j-1) & (s.charAt(i) == s.charAt(j));
}	
	
	
	public static void main(String[] args){
		String test = "abcbe";
		System.out.println(longestPalindrome(test));
	}
}
