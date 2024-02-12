import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 : N - 수열의 크기, 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> negative = new ArrayList<>(); //음수
		List<Integer> positive = new ArrayList<>(); //양수
		int zeroCount = 0; //0의 개수
		int oneCount = 0; //1의 개수
		for(int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			if(number < 0) negative.add(number);
			else if(number == 0) zeroCount++;
			else if(number == 1) oneCount++;
			else if(number > 0) positive.add(number);
		}
		int answer = 0;
		Collections.sort(negative);
		Collections.sort(positive, Collections.reverseOrder());
		while(negative.size() > 1) { //음수 절댓값 큰거끼리 곱해주기
			answer += negative.get(0) * negative.get(1);
			negative.remove(1);
			negative.remove(0);
		}
		while(positive.size() > 1) { //양수 값 큰거끼리 곱해서 더해주기
			answer += positive.get(0) * positive.get(1);
			positive.remove(1);
			positive.remove(0);
		}
		while(negative.size() != 0 && negative.size() <= zeroCount) {
			negative.remove(0);
			zeroCount--;
		}
		for(int i : negative) answer += i;
		for(int i : positive) answer += i;
		answer += oneCount;
		// 출력 : 최대 합
		System.out.println(answer);
	}
}
