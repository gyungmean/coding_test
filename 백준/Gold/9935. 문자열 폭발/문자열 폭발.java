import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static Stack<Character> stack = new Stack<>();
	static StringBuilder str, bomb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = new StringBuilder(br.readLine());
		bomb = new StringBuilder(br.readLine());
		
		stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			if(stack.peek() == bomb.charAt(bomb.length() - 1)) {
				if(bombCheck()) {
					for(int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder answer = new StringBuilder();
		if(stack.size() == 0) {
			answer.append("FRULA");
		}
		else {
			for(char c : stack) {
				answer.append(c);
			}
		}
		System.out.println(answer);
	}
	
	static boolean bombCheck() {
		if(stack.size() < bomb.length()) return false;
		for(int i = 0; i < bomb.length(); i++) {
			if(bomb.charAt(bomb.length() - 1 - i) != stack.get(stack.size() - 1 - i)) return false;
		}
		return true;
	}

}
