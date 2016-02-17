package medium;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author lichenjie0522
 *
 */
public class No148_SortList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode h1 = head;
		ListNode h2 = getMid(head);
		h1 = sortList(h1);
		h2 = sortList(h2);
		return merge(h1, h2);
	}

	private ListNode merge(ListNode h1, ListNode h2) {
		ListNode dummy = new ListNode(0);
		ListNode tmp = dummy;
		while (h1 != null && h2 != null) {
			if (h1.val < h2.val) {
				tmp.next = h1;
				h1 = h1.next;
			} else {
				tmp.next = h2;
				h2 = h2.next;
			}
			tmp = tmp.next;
		}
		if (h1 != null) {
			tmp.next = h1;
		}
		if (h2 != null) {
			tmp.next = h2;
		}
		return dummy.next;
	}

	private ListNode getMid(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = null;
		return slow;
	}

}
