import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.io.BufferedWriter;


public class Main {
	static int answer = 0;
	static Deque<Node> d;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //수의 개수
		int L = Integer.parseInt(st.nextToken()); //범위
		
		st = new StringTokenizer(br.readLine());
		
		d = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			Node now = new Node(i, Integer.parseInt(st.nextToken()));
			//크기 비교 후 deque에 넣기
			while(!(d.isEmpty()) && d.getLast().value > now.value) {
				d.pollLast();
			}
			d.addLast(now);
			//idx범위 확인
			//i - L + 1
			if(d.getFirst().idx < i - L + 1) {
				d.pollFirst();
			}
			bw.write(d.getFirst().value + " ");
		}
		bw.flush();
	}
	
	static class Node{
		int idx;
		int value;
		
		Node(int idx, int value){
			this.idx = idx;
			this.value = value;
		}
	}
}