class Solution {
     public  static long minimumSteps(String s) {
//        long count = 0;
//        int[] arr = new int[s.length()];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = s.charAt(i);
//        }
        int balck=0;
        long swap=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1'){
                balck++;
            }
            else{
                swap+=balck;
            }
        }

//        int i=0;
//        System.out.println(Arrays.toString(arr));

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - 1; j++) {
//                if (arr[j] > arr[j+ 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j+ 1];
//                    arr[j + 1] = temp;
//                    count++;
//                }
//            }
//        }
//        while(i<arr.length-1){
//            if(arr[i]>arr[i+1]){
//                int temp = arr[i];
//                arr[i] = arr[i+ 1];
//                  arr[i+ 1] = temp;
//                  count++;
//                  i=0;
//            }
//            else{
//                i++;
//            }
//        }

        return swap;

    }
}