class Solution {
    public String smallestBeautifulString(String s, int k) {
      int n=s.length();
      char arr[]=s.toCharArray();
      arr[n-1]++;
      for(int i=n-1;i<n;)
      {
          if(arr[i]=='a'+k)
          {
              arr[i--]='a';
              if(i<0)return "";
              arr[i]++;
          }
          else if((i>0&&arr[i]==arr[i-1])||(i>1&&arr[i]==arr[i-2]))arr[i]++;
          else i++;
      }
      return String.valueOf(arr);
}

    

}