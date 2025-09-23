class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1=version1.split("\\.");
        String[] ver2=version2.split("\\.");
        int i=0;
        int j=0;
        System.out.print(Arrays.toString(ver1));
        System.out.print(Arrays.toString(ver2));
        // int limit=Math.max(ver1.length,ver2.length);
        while(j<ver2.length ||  i<ver1.length){
            int v1=0;
            int v2=0;
            if(i<ver1.length){
                v1=Integer.parseInt(ver1[i]);
            }
            if(j<ver2.length){
                v2=Integer.parseInt(ver2[j]);
            }
            if(v1==v2){
                i++;
                j++;
            }
            else if(v1<v2){
                return -1;
            }
            else{
                return 1;
            }
        }
        return 0;
    }
}