package com.grv.linkedlist;

public class checkLoopInList {

	boolean hasCycle(LLNode head) {

		boolean hasLoop = false;
		if(head == null ) return false;

		LLNode slow = head;
		if(head.next == null || head.next.next==null) {
			return false;
		}

		LLNode fast = head.next.next ;


		while (slow != null){

			if(fast == null || fast.next == null) break;

			if( slow == fast) {
				hasLoop = true ;
				break;
			}

			slow = slow.next;
			fast = fast.next.next;
		}

		return hasLoop;
	}



}
