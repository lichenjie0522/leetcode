package medium;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author lichenjie0522
 *
 */
public class No061_RotateList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		
		ListNode node = head;
		int n = 1;
		while (node.next != null) {
			n++;
			node = node.next;
		}
		k %= n;
		if (k == 0) {
			return head;
		}
		node.next = head;
		for (int i = 0; i < n - k; ++i) {
			node = node.next;
		}
		head = node.next;
		node.next = null;
		return head;
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
		ListNode dummy = rotateRight(l1, 2);
		while (dummy != null){
			System.err.print(dummy.val + " ");
			dummy = dummy.next;
		}
	}
}
