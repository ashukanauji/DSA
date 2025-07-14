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
    public int getDecimalValue(ListNode head) {
        int len = 0;

        ListNode temp = head;

        while(temp != null){
            len++;
            temp = temp.next;
        }
        // System.out.println(len);
        int ans = 0;
        while(head != null && len >= 0){
            if(head.val == 1){
                ans += Math.pow(2, len-1);
                len--;
            }
            else
                len--;

            head = head.next;
                
        }
        return ans;
    }
}