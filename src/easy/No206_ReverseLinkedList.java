package easy;

/**
 * Reverse a singly linked list.
 * 
 * @author lichenjie0522
 *
 */
public class No206_ReverseLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p2 != null) {
			ListNode tmp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = tmp;
		}
		head.next = null;
		return p1;
	}

}
