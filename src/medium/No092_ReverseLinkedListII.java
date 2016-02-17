package medium;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * @author lichenjie0522
 *
 */
public class No092_ReverseLinkedListII {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode left = head;
		ListNode right = head;
		for (int i = 1; i < m; ++i) {
			prev = prev.next;
			left = left.next;
			right = right.next;
		}
		for (int i = m; i < n; ++i) {
			right = right.next;
		}
		ListNode next = right.next;
		right.next = null;
		prev.next = reverseList(left);
		left.next = next;
		return dummy.next;
	}
	
	private static ListNode reverseList(ListNode head) {
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
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode dummy = reverseBetween(l1, 2, 4);
		while (dummy != null){
			System.err.print(dummy.val + " ");
			dummy = dummy.next;
		}
	}
	
}
