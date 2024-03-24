import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[][] tree;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[26][2];
		for(int i = 1; i <= N; i++) {
			String line = br.readLine();
			int nowNode = line.charAt(0) - 65;
			if(line.charAt(2) == '.') {
				tree[nowNode][0] = -1;
			}
			else {
				tree[nowNode][0] = line.charAt(2) - 65;
			}
			if(line.charAt(4) == '.') {
				tree[nowNode][1] = -1;
			}
			else {
				tree[nowNode][1] = line.charAt(4) - 65;
			}
		}
		
		preOrder(0);
		sb.append("\n");
		inOrder(0);
		sb.append("\n");
		postOrder(0);
		
		System.out.println(sb);

	}

	static void preOrder(int now) {
		if(now == -1) {
			return;
		}
		sb.append((char)(now + 65));
		preOrder(tree[now][0]);
		preOrder(tree[now][1]);
		
	}
	
	static void inOrder(int now) {
		if(now == -1) {
			return;
		}
		inOrder(tree[now][0]);
		sb.append((char)(now + 65));
		inOrder(tree[now][1]);
	}
	
	static void postOrder(int now) {
		if(now == -1) {
			return;
		}
		postOrder(tree[now][0]);
		postOrder(tree[now][1]);
		sb.append((char)(now + 65));
	}
}
