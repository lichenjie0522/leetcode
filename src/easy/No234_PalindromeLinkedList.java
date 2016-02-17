package easy;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * @author lichenjie0522
 *
 */
public class No234_PalindromeLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) {
			// odd nodes
			slow.next = reverseList(slow.next);
			slow = slow.next;
		} else {
			// even nodes
			slow = reverseList(slow);
		}
		while (slow != null) {
			if (head.val != slow.val) {
				return false;
			}
			head = head.next;
			slow = slow.next;
		}
		return true;
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
