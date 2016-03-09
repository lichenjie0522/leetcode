package medium;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author lichenjie0522
 *
 */
public class No147_InsertionSortList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode insertionSortList_faster(ListNode head) {
        if(head == null) return head;
        ListNode current = head.next;
        ListNode pre = head;
        while(current !=null){
            if(current.val>=pre.val){
                current = current.next;
                pre = pre.next;
            }
            else{
                pre.next = current.next;
                if(current.val<=head.val){ //current value smaller than smallest value in the examined list
                    //insert current to the beginning
                    current.next = head;
                    head = current;
                }
                else{
                    ListNode search = head;
                    while(search.next != null && search.next.val<current.val){
                        search = search.next;
                    }
                    //insert current between search and search.next
                    ListNode tmp = search.next;
                    search.next = current;
                    current.next = tmp;
                }
                current = pre.next;
            }
        }
        return head;
    }

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		while (head != null) {
			ListNode node = dummy;
			while (node.next != null && node.next.val <= head.val) {
				node = node.next;
			}
			ListNode tmp = head.next;
			head.next = node.next;
			node.next = head;
			head = tmp;
		}
		return dummy.next;
	}
}
