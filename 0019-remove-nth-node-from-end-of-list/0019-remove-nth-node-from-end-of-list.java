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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        System.out.println(count);
        ListNode curr  = head;
        ListNode prev = null;
        for(int i = 0;i<count;i++){
            if(count-n==i){
                if(prev==null){
                    head = head.next;
                }else{
                prev.next = curr.next;
                }
                break;
            }
            prev = curr ;
            curr = curr.next;
        }
        return head;
    }
}