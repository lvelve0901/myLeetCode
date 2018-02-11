package test;
import java.util.Arrays;

import common.ListNode;

public class AddTwoNumbers {
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		int x = 0;
//		int digit = 0;
//		int a = 0, b = 0;
//    	ListNode ret = new ListNode(x);
//    	ListNode first = ret;
//    	boolean isNull1 = false, isNull2 = false;
//    	while(!(isNull1 & isNull2 & digit == 0)) {
//    		
//    		if (l1 == null) { a = 0; isNull1 = true;}
//    		else { a = l1.val; }
//    		if (l2 == null) { b = 0; isNull2 = true;}
//    		else { b = l2.val; }
//    		
//    		int current = a + b;
//    		if ((ret.val + current) < 10) {
//    			ret.val += current;
//    			digit = 0;
//    		}
//    		else {
//    			ret.val += (current - 10);
//    			digit = 1;
//    		}
//    		
//    		if (isNull1 & !isNull2) {
//    			if (!(l2.next == null & digit == 0)) {
//    				ret.next = new ListNode(digit);
//    				ret = ret.next;
//    			}
//    			l2 = l2.next;
//    		}
//    		
//    		if (!isNull1 & isNull2) {
//    			if (!(l1.next == null & digit == 0)) {
//    				ret.next = new ListNode(digit);
//    				ret = ret.next;
//    			}
//				l1 = l1.next;
//    		}
//    		
//    		if (!isNull1 & !isNull2) {
//    			if (!(l1.next == null & l2.next == null & digit == 0)) {
//    				ret.next = new ListNode(digit);
//    				ret = ret.next;
//    			}
//				l1 = l1.next;
//				l2 = l2.next;
//    		}
//			
//    	}
//    	
//    	return first;
//        
//    }
    
	public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
		ListNode first = new ListNode(0);
		ListNode a = l1, b = l2, current = first;
		int carry = 0;
		while (a != null || b != null || carry > 0) {
			current.next = new ListNode(carry);
			carry = 0;
			if ( a != null & b != null) { current.next.val += (a.val + b.val); }
			else if (a == null & b != null) {current.next.val += b.val;}
			else if (a != null & b == null) {current.next.val += a.val;}
			if (current.next.val >= 10) {
				current.next.val -= 10;
				carry = 1;
			}
			current = current.next;
			if (a != null) { a = a.next; }
			if (b != null) { b = b.next; }
		}
		
		return first.next;
	}
	
	public static void main(String[] args){
		int a1 = 2;
		int a2 = 4;
		int a3 = 3;
		int b1 = 5;
		int b2 = 6;
		int b3 = 4;
		ListNode la = new ListNode(a1);
		ListNode firsta = la;
		la.next = new ListNode(a2);
		la = la.next;
		la.next = new ListNode(a3);
		ListNode lb = new ListNode(b1);
		ListNode firstb = lb;
		lb.next = new ListNode(b2);
		lb = lb.next;
		lb.next = new ListNode(b3);
		ListNode first = addTwoNumbers(firsta, firstb);
		System.out.println("Result is:");
		while(first != null) {
			System.out.println(first.val);
			first = first.next;
		}
		
	}
    
}
