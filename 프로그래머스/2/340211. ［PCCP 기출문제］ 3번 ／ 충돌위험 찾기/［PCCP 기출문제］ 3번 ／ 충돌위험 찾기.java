import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        List<List<String>> robotPaths = new ArrayList<>();

        for (int[] route : routes) {

            List<String> path = new ArrayList<>();

            int r = points[route[0]-1][0];
            int c = points[route[0]-1][1];

            path.add(r + "," + c);

            for (int i = 1; i < route.length; i++) {

                int nr = points[route[i]-1][0];
                int nc = points[route[i]-1][1];

                // r 먼저 이동
                while (r != nr) {
                    r += (nr > r) ? 1 : -1;
                    path.add(r + "," + c);
                }

                // c 이동
                while (c != nc) {
                    c += (nc > c) ? 1 : -1;
                    path.add(r + "," + c);
                }
            }

            robotPaths.add(path);
        }

        int answer = 0;
        int time = 0;

        while (true) {

            Map<String, Integer> map = new HashMap<>();
            boolean finished = true;

            for (List<String> path : robotPaths) {

                if (time < path.size()) {
                    finished = false;
                    String pos = path.get(time);
                    map.put(pos, map.getOrDefault(pos, 0) + 1);
                }
            }

            if (finished) break;

            for (int v : map.values()) {
                if (v >= 2) answer++;
            }

            time++;
        }

        return answer;
    }
}