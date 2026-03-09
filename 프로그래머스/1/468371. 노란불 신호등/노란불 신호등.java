import java.util.*;

class Solution {

    public int solution(int[][] signals) {
        
        int lcm = 1;
        
        for(int[] s : signals){
            int cycle = s[0] + s[1] + s[2];
            lcm = lcm(lcm, cycle);
        }

        for(int t = 1; t <= lcm; t++) {
            
            boolean allYellow = true;

            for(int[] s : signals){
                int g = s[0];
                int y = s[1];
                int r = s[2];

                int cycle = g + y + r;
                int time = (t - 1) % cycle;

                if(!(time >= g && time < g + y)){
                    allYellow = false;
                    break;
                }
            }

            if(allYellow) return t;
        }

        return -1;
    }

    int gcd(int a, int b){
        while(b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    int lcm(int a, int b){
        return a / gcd(a,b) * b;
    }
}