class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            int length=(int)Math.log10(Math.abs(i))+1;
            if(length%2==0){
                int half=length/2;
                int mul=(int)Math.pow(10,half);
                int st=0;
                int end=0;
                int first=i/mul;
                int last=i%mul;
                while(first>0){
                    int r=first%10;
                    st+=r;
                    first/=10;
                }
                while(last>0){
                    int r=last%10;
                    end+=r;
                    last/=10;
                }
                if(st==end){
                    count++;
                }
            }
        }
        return count;
    }
}