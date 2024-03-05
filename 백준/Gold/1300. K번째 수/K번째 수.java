import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long start = 1;
        long end = k;
        long answer = 0;
        while(start <= end) {
            long mid = (start + end) / 2;
            long smallerCount = 0;
            for(int i = 1; i <= N; i++) {
                smallerCount += Math.min(mid / i, N);
            }
            if(smallerCount >= k) {
            	end = mid - 1;
            	answer = mid;
            }
            else start = mid + 1;
        }
        System.out.println(answer);
    }
}