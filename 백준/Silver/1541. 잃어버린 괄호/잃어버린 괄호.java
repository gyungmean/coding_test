import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		List<Integer> number = new ArrayList<>();
		List<Character> operator = new ArrayList<>();
		int tmpNum = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '+' || str.charAt(i) == '-') {
				number.add(tmpNum);
				tmpNum = 0;
				operator.add(str.charAt(i));
			}
			else {
				tmpNum = tmpNum * 10 + str.charAt(i) - '0';
			}
		}
		number.add(tmpNum); //마지막 숫자 넣어주기
		
		Stack<Integer> s = new Stack<>();
		int plusResult = number.get(number.size() - 1); //마지막 숫자
		for(int i = operator.size() - 1; i >= 0; i--) {
			if(operator.get(i) == '+') {
				plusResult += number.get(i);
			}
			else {
				s.push(plusResult);
				plusResult = number.get(i);
			}
		}
		s.push(plusResult);
		
		int result = s.pop();
		while(!s.isEmpty()) {
			result -= s.pop();
		}
		System.out.println(result);
		
		
	}

}
