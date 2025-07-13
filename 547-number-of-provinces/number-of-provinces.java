class Solution {

    private void dfs(int node, ArrayList<Integer> isVisited, ArrayList<ArrayList<Integer>> adjList){
        if(isVisited.get(node) == 0){
            isVisited.set(node, 1);
            for(int neighbor: adjList.get(node)){
                if(isVisited.get(neighbor) == 0)
                    dfs(neighbor, isVisited, adjList);
            }
        }
            

    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(isConnected.length + 1);

        ArrayList<Integer> isVisited = new ArrayList<>(isConnected.length + 1);
        

        for(int i = 0; i <= isConnected.length; i++){
            adjList.add(new ArrayList<>());
            isVisited.add(0);
        }

        for(int i = 0; i < isConnected.length; i++){
            int j = 0;
            while(j < isConnected.length){
                if(i != j && isConnected[i][j] == 1)
                    adjList.get(i+1).add(j+1);
                j++;
            }
        }

        int count = 0;

        for(int i = 1; i <= isConnected.length; i++){
            if(isVisited.get(i) == 0){
                dfs(i, isVisited, adjList);
                count++;
            }
        }

        return count;
    }
}