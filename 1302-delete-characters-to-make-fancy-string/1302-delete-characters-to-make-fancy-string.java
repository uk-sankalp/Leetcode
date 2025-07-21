class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        int count=0;
        int i=0;
        int j=0;
        while(i<s.length() && j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                count++;
                j++;
            }
            else{
                    sb.append(s.charAt(i));
                    if(count>=2){
                    sb.append(s.charAt(i));
                    }
                    count=0;
                    i=j;
                }
        }
                
                if(count>0){
                    sb.append(s.charAt(i));
                    if(count>=2){
                        sb.append(s.charAt(i));
                    }
                    }
                    return sb.toString();
            }
            
        }
        
