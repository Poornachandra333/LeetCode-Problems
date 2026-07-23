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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        Stack<Integer>st = new Stack<>();
        ListNode curr = head;
        while(curr!=null){
            st.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while(curr!=null){
            if(curr.val!=st.peek()){
                return false;
            }
            curr = curr.next;
            st.pop();
        }
        //System.out.println(st);
        return true;
    }
}