class Solution {
         public static int percentageLetter(String s, char letter) {
        double sl=s.length();
        double count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==letter){
                count++;
            }
        }
        double percentage=(count/sl)*100;
//        System.out.println(percentage);
        return (int)percentage;
    }
}