package easy;

/**
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * Example: Given 1->2->3->4->5->NULL, return 1->3->5->2->4->NULL.
 * 
 * Note: The relative order inside both the even and odd groups should remain as
 * it was in the input. The first node is considered odd, the second node even
 * and so on ...
 * 
 * @author lichenjie0522
 *
 */
public class No328_OddEvenLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode oddHead = head, evenHead = head.next;
		ListNode prevOdd = oddHead, prevEven = evenHead;

		while (prevOdd.next != null && prevEven.next != null) {
			prevOdd.next = prevEven.next;
			prevOdd = prevOdd.next;

			prevEven.next = prevOdd.next;
			prevEven = prevEven.next;
		}
		prevOdd.next = evenHead;

		return oddHead;
	}
}
