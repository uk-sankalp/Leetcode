class Solution {
    public int maxArea(int[] height) {
      int max_area=0;
      int i=0;
      int j=height.length-1;
      while(i<j){
        int area=(Math.min(height[i],height[j]))*(j-i);
        max_area=Math.max(max_area,area);
        if(height[i]<height[j]){
            i++;
        }
        else{
            j--;
        }
      }
      return max_area;  
    }
}