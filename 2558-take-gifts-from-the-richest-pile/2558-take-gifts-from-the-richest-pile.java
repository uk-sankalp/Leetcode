class Solution {
   public static long pickGifts(int[] gifts, int k) {
        long sum=0;

        class Helper{
            int max=Integer.MIN_VALUE;
            int index=0;
            int index_max(int[] arr){
                for (int i = 0; i < gifts.length; i++) {
                    if(gifts[i]>max){
                        max=gifts[i];
                        index=i;
                    }

                }
                max=Integer.MIN_VALUE;
                return index;
            }
        }
        Helper help=new Helper();
        int index=help.index_max(gifts);

        while (k>0){
            int value=gifts[index];
            value= (int) (value-Math.floor((Math.sqrt(value))));
            gifts[index]=gifts[index]-value;
//            System.out.println(Arrays.toString(gifts));
            k--;
            index=help.index_max(gifts);


        }
        for (int gift : gifts) {
            sum += gift;
        }
        return sum;
    }
}