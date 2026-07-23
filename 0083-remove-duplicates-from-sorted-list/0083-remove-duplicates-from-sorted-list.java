/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode prev = new ListNode(head.val);
        dummy.next = prev;
        dummy = dummy.next;
        if(head.next==null){
            return prev;
        }
        ListNode curr = head.next;
        while(curr!=null){
            if(curr.val==prev.val){
                curr = curr.next;
            }
            else{
                ListNode node = new ListNode(curr.val);
                dummy.next = node;
                dummy = dummy.next;
                prev = curr;
                curr = curr.next;
            }
        }
        return temp.next;
    }
}