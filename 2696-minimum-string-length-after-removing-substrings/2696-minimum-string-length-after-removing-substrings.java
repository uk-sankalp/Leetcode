class Solution {

    public int minLength(String s) {

        System.out.println(s);

        int l = s.length();

        for(int i=0;i<l;i++)

        {

            if(s.charAt(i)=='A' && i!=l-1)

            {

                if(s.charAt(i+1)=='B')

                {

                    String w = s.substring(0,i) + s.substring(i+2,l);

                    return minLength(w);

                }

            }

            if(s.charAt(i)=='C' && i!=l-1)

            {

                if(s.charAt(i+1)=='D')

                {

                    String w = s.substring(0,i) + s.substring(i+2,l);

                    return minLength(w);

                }

            }

        }

        return s.length();

    }

}

        

