import java.util.*;
import java.awt.*;
class Solution {
    int[] dx = { 1, -1, 0, 0 }, dy = {0, 0, -1, 1};
    int mx, my;
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Set<Integer> matsSet = new HashSet<>();
        for(int m : mats) {
            matsSet.add(m);
        }
        mx = park.length;
        my = park[0].length;
        for(int i = 0; i < mx; i++) {
            for(int j = 0; j < my; j++) {
                if(!park[i][j].equals("-1")) continue;
                int size = find(park, i, j);
                if(size > answer && matsSet.contains(size)) {
                    answer = size;
                }
            }
        }
        return answer == 0 ? -1 : answer;
    }
    
    int find(String[][] park, int x, int y) {
        int size = 0;

        while (x + size < mx && y + size < my) {

            for (int i = x; i <= x + size; i++) {
                for (int j = y; j <= y + size; j++) {
                    if (!park[i][j].equals("-1")) {
                        return size;
                    }
                }
            }

            size++;
        }

        return size;
    }
}