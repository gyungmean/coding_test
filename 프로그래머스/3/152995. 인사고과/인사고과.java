import java.util.*;

class Solution {
    public int solution(int[][] scores) {

        int[] wanho = scores[0];
        int wanhoSum = wanho[0] + wanho[1];

        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; //동료평가점수 오름차순
            }
            return b[0] - a[0]; //태도점수 내림차순
        });

        int answer = 1;
        int maxPeer = 0;

        for (int[] s : scores) {
            int att = s[0];
            int peer = s[1];

            if (peer < maxPeer) {
                if (att == wanho[0] && peer == wanho[1]) {
                    return -1;
                }
                continue;
            }

            if (att + peer > wanhoSum) {
                answer++;
            }

            maxPeer = Math.max(maxPeer, peer);
        }

        return answer;
    }
}