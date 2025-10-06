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
    public ListNode rotateRight(ListNode head, int k) {
        if(k<=0 || head==null || head.next==null){
            return head;
        }
        ListNode temp=head;
        int len=1;
        while(temp.next!=null){
            temp=temp.next;
            len++;
        }
        temp.next=head;
        k=k%len;
        int ind=1;
        ListNode temp2=head;
        while(ind<(len-k)){
            temp2=temp2.next;
            ind++;
        }
        ListNode ans=temp2.next;
        temp2.next=null;
        return ans;
    }
}