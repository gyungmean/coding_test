import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 : N - 수열의 크기 , 수열 배열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) { 
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//stack에 top보다 크면 안에있는거 pop하기
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int[] NGE = new int[N];
		for(int i = 1; i < N; i++) { 
			while(arr[stack.peek()] < arr[i]) {
				NGE[stack.pop()] = arr[i];
				if(stack.isEmpty()) break;
			}
				stack.push(i);
		}
		while(!stack.isEmpty()) {
			NGE[stack.pop()] = -1;
		}

		//출력 : NGE 공백두고 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int n : NGE) {
			bw.append(n + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
