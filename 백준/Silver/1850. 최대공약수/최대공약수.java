import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long digit = gcp(A, B);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= digit; i++) {
			sb.append(1);
		}
		System.out.println(sb);

	}
	static long gcp(long a, long b) {
		if(b == 0) return a;
		else return gcp(b, a % b);
	}

}
