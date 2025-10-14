class Solution {
    public static boolean isSame(char[] arr, char [] arr2, int n){
        for(int i=0;i<n;i++){
            if(arr[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> dummy=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            dummy.add(words[i]);
        }
        for(int i=words.length-1;i>0;i--){
            if(words[i].length()==words[i-1].length()){
                char[] charArray1 = words[i].toCharArray();
                char[] charArray2 = words[i-1].toCharArray();
                Arrays.sort(charArray1);
                Arrays.sort(charArray2);
                if(isSame(charArray1,charArray2,charArray1.length)){
                    dummy.remove(i);
                }
            }
        }
        return dummy;
    }
}