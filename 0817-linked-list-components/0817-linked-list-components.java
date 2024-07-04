class Solution {
    public int numComponents(ListNode head, int[] nums) {
        if (head.next==null){
            return 1;
        }
        int cnt=nums.length;
        boolean bool=false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i: nums){
            map.put(i,null);
        }
        while(head!=null){
            if (map.containsKey(head.val)){
                if (bool){
                    cnt--;
                }
                else{
                    bool=true;
                }
            }
            else{
                bool = false;
            }
            head=head.next;
        }
        return cnt;
    }
    
}