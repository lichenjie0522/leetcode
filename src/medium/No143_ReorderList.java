package medium;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author lichenjie0522
 *
 */
public class No143_ReorderList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode mid = findMid(head);
		ListNode head2 = reverseList(mid.next);
		mid.next = null;

		ListNode dummy = new ListNode(-1);
		ListNode node = dummy;
		boolean flag = true;
		while (head != null && head2 != null) {
			if (flag) {
				node.next = head;
				head = head.next;
			} else {
				node.next = head2;
				head2 = head2.next;
			}
			flag = !flag;
			node = node.next;
		}

		if (head == null) {
			node.next = head2;
		} else {
			node.next = head;
		}
		head = dummy.next;
	}

	private ListNode findMid(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private ListNode reverseList(ListNode head) {
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
