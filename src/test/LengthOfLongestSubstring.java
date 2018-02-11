package test;

import java.util.HashMap;

public class LengthOfLongestSubstring {
//	public int lengthOfLongestSubstring(String s) {
//        int maxsublen = 0; // maximal substring length
//        int currsublen = 0; // current substring length
//        int backnode = 0; // record the first non-repeated char
//        int slen = s.length();
//        HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
//        for (int i = 0; i < slen; i ++) {
//        	if (hmap.containsKey(s.charAt(i))) {
//        		int newnode = hmap.get(s.charAt(i));
//        		for (int j = backnode; j < newnode; j ++) {
//        			hmap.remove(s.charAt(j));
//        		}
//        		backnode = newnode + 1;
//        		hmap.put(s.charAt(i),i); // hashmap update the character position
//        		currsublen = i - backnode + 1;
//        	}
//        	else {
//        		currsublen += 1;
//        		hmap.put(s.charAt(i),i);
//        		if (currsublen > maxsublen) {
//        			maxsublen = currsublen;
//        		}
//        	}
//        }
//        return maxsublen;
//    }
	
	public int lengthOfLongestSubstring(String s) {
		int ans = 0;
		int n = s.length();
		HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
		for (int i=0,j=0;j<n;j++) {
			if (hmap.containsKey(s.charAt(j))) {
				i = Math.max(hmap.get(s.charAt(j))+1, i);
			}
			ans = Math.max(ans, j-i+1);
			hmap.put(s.charAt(j),j);
		}
		return ans;
	}
}
