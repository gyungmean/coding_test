import java.util.*;
class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a) {
            int set = n / a;
            int remain = n % a;
            n = set * b + remain;
            answer += (set * b);
        }
        return answer;
    }
}