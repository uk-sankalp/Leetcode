class Solution {
    public int sumImbalanceNumbers(int[] nums) {        
        int n = nums.length;        
        int count = 0;
        
        for(int i = 0; i < n - 1; i++){            
            int arr[] = new int[1005];            
            arr[nums[i]] = 1;            
            int temp = 0;
            
            for(int j = i + 1; j < n; j++){                
                int val = nums[j];                        
                if(arr[val] == 1) {                    
                    count += temp;
                } else {                    
                    if(arr[val - 1] == 0 && arr[val + 1] == 0) {
                        temp++;
                    } else if(arr[val - 1] == 1 && arr[val + 1] == 1){
                        temp--;                        
                    }                     
                    if(temp < 0) temp = 0;                   
                    arr[val] = 1;
                    count += temp;
                }                
            }            
        }        
        return count;
    }
}