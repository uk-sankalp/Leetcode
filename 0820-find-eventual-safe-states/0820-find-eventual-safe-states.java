class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       List<Integer> safe=new ArrayList<>();
       List<List<Integer>> adj=new ArrayList<>();
       int[] visited=new int[graph.length];
       int[] path=new int[graph.length];
       int[] check=new int[graph.length];
       for(int i=0;i<graph.length;i++){
        adj.add(new ArrayList<>());
       }
       for(int i=0;i<graph.length;i++){
        for(int edge:graph[i]){
            adj.get(i).add(edge);
        }
       }
       for(int i=0;i<graph.length;i++){
        if(visited[i]==0){
            dfs(i,visited,path,check,adj);
        }
       }
       for(int i=0;i<graph.length;i++){
        if(check[i]==1){
            safe.add(i);
        }
       }
       return safe;
    }
    public static boolean dfs(int i,int[] visited,int[] path,int[] check,List<List<Integer>> adj){
        visited[i]=1;
        path[i]=1;
        for(int it:adj.get(i)){
            if(visited[it]==0){
                if(dfs(it,visited,path,check,adj)){
                    return true;
                }
            }
            else if(path[it]==1){
                return true;
            }
        }
        path[i]=0;
        check[i]=1;
        return false;
    }
}