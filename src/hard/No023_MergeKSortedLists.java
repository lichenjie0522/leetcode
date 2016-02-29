package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * 先建立一个自带Comparator的min-oriented PriorityQueue。初始把所有非空list head都放进pq，
 * 之后poll出当前最小的值设置为node.next，假如这条list非空，则将其之后的节点作为head放入pq中继续进行比较。
 * 这里insert和deleteMin操作复杂度都是O(logk)，k是lists.length
 * 
 * Time Complexity - O(nlogk)， Space Complexity - O(k)， 这里k为lists的长度， n为所有的节点数
 * 
 * @author lichenjie0522
 *
 */
public class No023_MergeKSortedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(-1);
		ListNode node = dummy;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});
		for (ListNode head : lists) {
			if (head != null) {
				pq.offer(head);
			}
		}
		while (pq.size() > 0) {
			node.next = pq.poll();
			node = node.next;
			if (node.next != null) {
				pq.offer(node.next);
			}
		}
		return dummy.next;
	}
}
