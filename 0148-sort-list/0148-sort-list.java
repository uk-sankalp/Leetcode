class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // If list is empty or has only one node, return the head
        }
        ListNode mid=findMiddle(head);
        ListNode rightHead=mid.next;
        mid.next=null;
        ListNode newLeft=sortList(head);
        ListNode newRight=sortList(rightHead);
        return Merge(newLeft,newRight);
    }

    public ListNode Merge(ListNode head1,ListNode head2){
        ListNode mergedLL=new ListNode(-1);
        ListNode temp=mergedLL;

        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;

    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer one step
            fast = fast.next.next;    // Move fast pointer two steps
        }
        return slow; // When fast pointer reaches the end, slow pointer is at the middle
    }
}