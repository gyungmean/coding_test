import java.util.*;

class Solution {

    int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        int[] selected = new int[5];
        dfs(1, 0, n, selected, q, ans);
        return answer;
    }

    void dfs(int start, int depth, int n, int[] selected, int[][] q, int[] ans) {

        if (depth == 5) {
            if (isPossible(selected, q, ans)) {
                answer++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            dfs(i + 1, depth + 1, n, selected, q, ans);
        }
    }

    boolean isPossible(int[] selected, int[][] q, int[] ans) {

        for (int i = 0; i < q.length; i++) {

            int count = 0;

            for (int a : selected) {
                for (int b : q[i]) {
                    if (a == b) {
                        count++;
                    }
                }
            }

            if (count != ans[i]) {
                return false;
            }
        }

        return true;
    }
}