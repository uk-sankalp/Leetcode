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
       int sum = 0;
        
        while (head != null){
            sum *= 2;
            sum += head.val;
            head = head.next;
        }
        return sum;
    }
}
/*
int value=0;
        int ans=0;
        ListNode temp=head;
        while(temp!=null){
            value=value *10+temp.val;
            temp=temp.next;
        }
        int ind=-1;
        while(value>0){
            int r=value%10;
            ind++;
            ans=ans+r*(int)(Math.pow(2,ind));
            value/=10;
        }
        return ans;
 */