import java.util.Collection;class Solution {
  
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
     int len = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = len - Math.min(tasks.length, workers.length);
        int right = len;

        while (left < right) {
            int mid = (left + right) / 2;
            boolean canComplete = gg(tasks, workers, pills, strength, mid);
            
            if (canComplete) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return len - left;
    }

    boolean gg(int[] tasks, int[] workers, int pills, int strength,int begin)
    {
        Deque<Integer>d=new LinkedList<>();
        if(begin==workers.length)
            return false;
        int i=0;
        for(int j=begin;j<workers.length;j++)
        {
            if(!d.isEmpty())
            {
                if(d.peek()<=workers[j])
                    d.poll();
                else{
                    if(pills==0)
                        return false;
                    while(i<tasks.length&&tasks[i]<=workers[j]+strength)
                        d.add(tasks[i++]);
                    d.pollLast();
                    pills--;
                }
            }
            else
                if(i==tasks.length)
                    return false;
                else if(tasks[i]<=workers[j])
                    i++;
                else
                    if(pills==0)
                        return false;
                else{
                 while(i<tasks.length&&tasks[i]<=workers[j]+strength)
                        d.add(tasks[i++]);
                    if(d.isEmpty())
                        return false;
                    d.pollLast();
                    pills--;
                }
        }
        return true;
    }
    
   
}