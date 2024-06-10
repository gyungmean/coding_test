import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static int MAX_VALUE = 10000001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long[] arr = new long[MAX_VALUE];
		for(int i = 2; i < MAX_VALUE; i++) {
			arr[i] = i;
		}
		for(int i = 2; i <= Math.sqrt(MAX_VALUE); i++) { //에라토스테네스의 체
			if(arr[i] == 0) continue;
			for(int j = i + i; j < MAX_VALUE; j = j + i) {
				arr[j] = 0;
			}
		}
		
		int count = 0;
		for(int i = 2; i < MAX_VALUE; i++) {
			if(arr[i] != 0) {
				long temp = arr[i];
				while((double)arr[i] <= (double)B / (double)temp) {
					if((double)arr[i] >= (double)A / (double)temp) {
						count++;
					}
					temp = temp * arr[i];
				}
			}
		}
		System.out.println(count);
	}

}
