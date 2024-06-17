import java.util.*;
class Solution {
    List<List<Integer>> tree = new LinkedList<>();
    public int solution(int n, int[][] wires) {
        for(int i = 0; i <= n; i++){
            tree.add(new LinkedList<>());
        }
        //System.out.println(wires.length);
        for(int i = 0; i < wires.length; i++){
            tree.get(wires[i][0]).add(wires[i][1]);
            tree.get(wires[i][1]).add(wires[i][0]);
        }
        //System.out.println(tree.get(2));
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
 
            boolean[] visited = new boolean[n + 1];
 
            // 해당 간선을 그래프에서 제거
            tree.get(v1).remove(Integer.valueOf(v2));
            tree.get(v2).remove(Integer.valueOf(v1));
 
            int cnt = countNode(1, visited); // 임의의 시작점에서 dfs 탐색
 
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
 
            // 그래프에 다시 간선 추가
            tree.get(v1).add(v2);
            tree.get(v2).add(v1);
        }
        
//         int maxCount = -1;
//         int maxNode = 0;
//         for(int i = 1; i <= n; i++) {
//             if(maxCount <= tree.get(i).size()){
//                 maxCount = tree.get(i).size();
//                 maxNode = i;
//             }
//         }
//        //System.out.println(maxNode);
        
//         int[] counts = new int[tree.get(maxNode).size()];
//         for(int i = 0; i < tree.get(maxNode).size(); i++){
//             counts[i] = countNode(maxNode, tree.get(maxNode).get(i)) + 1;
//         }
//         //System.out.println(Arrays.toString(counts));
        
//         maxCount = -1;
//         int maxNodeIndex = 0;
//         for(int i = 0; i < tree.get(maxNode).size(); i++){
//             if(maxCount <= counts[i]){
//                 maxNodeIndex = i;
//                 maxCount = counts[i];
//             }
//         }
//         //System.out.println(maxCount);
//         tree.get(maxNode).remove(maxNodeIndex);
        
//         int temp = 0;
//         for(int i = 0; i < tree.get(maxNode).size(); i++){
//             temp += countNode(maxNode, tree.get(maxNode).get(i)) + 1;
//         }
//         //System.out.println(temp + 1);
//         //System.out.println(Math.abs(temp + 1 - maxCount));
        
        int answer = min;
        return answer;
    }
    
    int countNode (int start, boolean[] visited){
        int count = 0;
        for(int n : tree.get(start)){
            if(visited[n]) continue;
            count++;
            visited[n] = true;
            count += countNode(n, visited);
        }
        return count;
    }
}