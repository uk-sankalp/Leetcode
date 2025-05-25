class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // boolean[] visited=new boolean[numCourses];
        int[] indegree=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            int u=p[0];
            int v=p[1];
            adj.get(v).add(u);
        }
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int node=q.remove();
            count++;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(count==numCourses){
            return true;
        }
        return false;
    }
}