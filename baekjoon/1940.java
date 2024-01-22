import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); // 1 2 3 4 5 7
		
		int count = 0;
		int start = 0;
		int end = N - 1;
		int sum;
		while(start < end) {
			if(A[start] + A[end] < M) {
				start++;
			}
			else if(A[start] + A[end] > M) {
				end--;
			}
			else {
				count++;
				start++;
				end--;
			}
			
		}
		System.out.println(count);
	}

}
