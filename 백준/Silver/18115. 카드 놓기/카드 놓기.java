import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) {
			int op = Integer.parseInt(st.nextToken());
			switch(op) {
			case 1:
				dq.addFirst(i);
				break;
			case 2:
				if(dq.isEmpty()) dq.addFirst(i);
				else {
					int tmp = dq.pollFirst();
					dq.addFirst(i);
					dq.addFirst(tmp);
				}
				break;
			case 3:
				dq.addLast(i);
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!dq.isEmpty()) {
			sb.append(dq.pollFirst()).append(" ");
		}
		System.out.println(sb);

	}

}
