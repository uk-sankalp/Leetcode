class Solution {
   public int minOperations(int[] target, int[] arr) {

        // 0. n이 1000 이하면 LCS로 풀이 가능 
        //    target의 숫자가 unique한 것을 이용해 arr을 변형해주고 
        //    LIS 형태로 풀이 

        // 1. target의 숫자들을 hashMap을 이용해 seq 를 지정해준다. 
        // 2. arr에서 1.에서 만든 map에 있는 숫자들만 list에 순차적으로 붙여준다.
        // 3. list에서 최장 증가 수열을 찾아 준다. 
        //     ※ LIS(binarySearch를 이용한 o(nlogn) 형태로 풀어주면된다.
        // 4. arr.length 에서 3에서 찾은 가장 긴 수열의 길이를 빼준 값을 반환

        
        int seq = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < target.length; i++) {
            map.put(target[i], seq);
            seq++;
        }

        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < arr.length; i++) {
            if ( map.containsKey(arr[i]) ) {
                list.add(map.get(arr[i]));
            }
        }


        List<Integer> seqList = new ArrayList<Integer>();

        for(int i = 0; i < list.size(); i++) {
            int currentSeq =  list.get(i);

            int idx = binarySearchUpper(seqList, currentSeq);


            if ( idx == seqList.size()) {
                seqList.add(currentSeq);
            } else{
                seqList.set(idx, currentSeq);
            }
            
        }


        return target.length - seqList.size();
    }

    private int binarySearchUpper(List<Integer> list, int target) {

        int start = 0;
        int end = list.size();
        int mid;

        while(start < end ) {
            mid = (start + end)/2;

            if ( list.get(mid) >= target ) {
                end = mid;
            } else{
                start = mid+1;
            }
        }

        return end;
    }
}