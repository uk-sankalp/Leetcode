class Solution {
    public String sortVowels(String s) {
        char[] array=s.toCharArray();
        ArrayList<Character> list=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i]=='a' || array[i]=='e' || array[i]=='i' || array[i]=='o' || array[i]=='u'
            || array[i]=='A' || array[i]=='E' || array[i]=='I' || array[i]=='O' || array[i]=='U'){
                list.add(array[i]);
            }
        }
        Collections.sort(list);
        // System.out.print(list);
        int ind=0;
        for(int i=0;i<array.length;i++){
            if(array[i]=='a' || array[i]=='e' || array[i]=='i' || array[i]=='o' || array[i]=='u'
            || array[i]=='A' || array[i]=='E' || array[i]=='I' || array[i]=='O' || array[i]=='U'){
                array[i]=list.get(ind);
                ind++;
            }
        }
        // System.out.print(array);
        return new String(array);
    }
}