class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        // BFS Method
//       Queue<Integer> q = new LinkedList<>();
//       boolean[] visited = new boolean[rooms.size()];

//       q.offer(0);
//       visited[0] = true;

//       while(!q.isEmpty()){
//         int room = q.poll(); 

//         for(int key : rooms.get(room)){
//             if(!visited[key]){
//                 visited[key] = true;
//                 q.offer(key);
//             }
//         }
//       }
//       for(boolean room : visited){
//         if(!room){
//             return false;
//         }
//       }
//       return true;
    
//     }
// }
     boolean[] visited = new boolean[rooms.size()];
     dfs(0,rooms,visited);

     for(boolean room : visited){
        if(!room){
            return false;
        }
     }
     return true;
    }
    private void dfs(int node, List<List<Integer>> rooms, boolean[] visited){
        visited[node] =true;

        for(int neighbour : rooms.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, rooms,visited);
            }
        }
    }
}
