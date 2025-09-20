class Solution {
    private boolean check(int start, int[][]graph, int[] color){

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        color[start] = 1;

        while(!q.isEmpty()){
            int node = q.poll();
        
            for(int neighbor: graph[node]){
                if(color[neighbor] == 0 && color[node] == 1){
                    color[neighbor] = 2;
                    q.add(neighbor);
                }
                    
                if(color[neighbor] == 0 && color[node] == 2){
                    color[neighbor] = 1;
                    q.add(neighbor);
                }
                
                if(color[neighbor] == color[node])
                    return false; 
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for(int i = 0; i < n; i++){
            if(color[i] == 0){
                if(check(i, graph, color) == false)
                    return false;
            }
        }

        return true;
    }
}