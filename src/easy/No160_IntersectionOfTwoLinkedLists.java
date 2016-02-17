package easy;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null. The linked
 * lists must retain their original structure after the function returns. You
 * may assume there are no cycles anywhere in the entire linked structure. Your
 * code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @author lichenjie0522
 *
 */
public class No160_IntersectionOfTwoLinkedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode nodeA = headA, nodeB = headB, tailA = null, tailB = null;
		while (nodeA != null && nodeB != null) {
			if (nodeA.next != null) {
				nodeA = nodeA.next;
			} else if (tailA == null) {
				tailA = nodeA;
				nodeA = headB;
			}
			if (nodeB.next != null) {
				nodeB = nodeB.next;
			} else if (tailB == null) {
				tailB = nodeB;
				nodeB = headA;
			}
			if (tailA != null && tailB != null) {
				if (tailA.val != tailB.val) {
					return null;
				}
				if (nodeA.val == nodeB.val) {
					return nodeA;
				}
			}
		}
		return nodeA;
	}
}
