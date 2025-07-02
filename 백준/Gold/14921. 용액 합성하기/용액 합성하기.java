import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        int min = 0;
        int max = N - 1;
        while(min < max) {
            int sum = solutions[min] + solutions[max];
            //System.out.println(solutions[min] + " + " + solutions[max] + " = " + sum);
            answer = Math.abs(answer) > Math.abs(sum) ? sum : answer;
            if(sum > 0) {
                max--;
            }
            else {
                min++;
            }
        }
        System.out.println(answer);
    }
}