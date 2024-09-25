class Solution {
    public static int finalValueAfterOperations(String[] operations) {
        int x=0;
        for (int i = 0; i < operations.length; i++) {
        if(operations[i].equals("++X") || operations[i].equals("X++") ){
            x++;
        }
            if (operations[i].equals("--X") || operations[i].equals("X--")) {
                x--;
            }
        
        }
        return x;
    }
}