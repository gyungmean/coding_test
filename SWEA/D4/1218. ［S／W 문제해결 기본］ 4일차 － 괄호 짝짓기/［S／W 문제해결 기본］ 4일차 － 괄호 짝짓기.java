import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 : T 문자열 길이, 괄호 문자열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N * N 달팽이 배열, visited 배열, 방향배열
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split("");
			int answer = 1;
			Stack<String> s = new Stack<>();
			for(int i = 0; i < N; i++) {
				switch(str[i]) {
				case "{": case "[": case "(": case "<":
					s.add(str[i]);
					break;
				case "}": 
					if(s.peek().equals("{")) {
						s.pop();
					}
					else {
						answer = 0;
						break;
					}
					break;
				case "]": 
					if(s.peek().equals("[")) {
						s.pop();
					}
					else {
						answer = 0;
						break;
					}
					break;
				case ")": 
					if(s.peek().equals("(")) {
						s.pop();
					}
					else {
						answer = 0;
						break;
					}
					break;
				case ">":
					if(s.peek().equals("<")) {
						s.pop();
					}
					else {
						answer = 0;
						break;
					}
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		// 출력 : 유효성 여부
		br.close();
	}
}
