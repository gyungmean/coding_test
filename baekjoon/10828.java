import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < N; i++) {
			String command = bf.readLine();
			String[] command_arr = command.split(" ");
			stackManger(command_arr);
		}
	}
	
	public static void stackManger(String[] command_arr) {
		switch(command_arr[0]) {
		case "push":
			stack.push(Integer.parseInt(command_arr[1]));
			break;
		case "pop":
			if(stack.empty()) {
				System.out.println("-1");
				return;
			}
			System.out.println(stack.pop());
			break;
		case "size":
			System.out.println(stack.size());
			break;
		case "empty":
			if(stack.empty()) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
			break;
		case "top":
			if(stack.empty()) {
				System.out.println("-1");
				return;
			}
			System.out.println(stack.peek());
			break;
		}
	}

}
