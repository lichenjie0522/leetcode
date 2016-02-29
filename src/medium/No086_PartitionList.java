package medium;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author lichenjie0522
 *
 */
public class No086_PartitionList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode node = head;
		ListNode greaterNode = new ListNode(-1);
		ListNode tail = greaterNode;
		while (node != null) {
			if (node.val >= x) {
				tail.next = node;
				prev.next = node.next;
				node = node.next;
				tail = tail.next;
				tail.next = null;
			} else {
				prev = prev.next;
				node = node.next;
			}
		}
		prev.next = greaterNode.next;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		ListNode ans = partition(n1, 3);
		while (ans != null) {
			System.out.print(ans.val + "->");
			ans = ans.next;
		}
	}
}
