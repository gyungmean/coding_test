import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int[] count_arr = {0, 0, 0, 0};
	static int[] condition = {0, 0, 0, 0};
	static int answer = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()); //DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken()); //부문 문자열 길이

		String[] dna_arr = br.readLine().split(""); //입력받은 문자열
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			condition[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		//초기 카운팅
		for(int i = 0; i < P; i++) {
			count(dna_arr[i]);
		}
		for(int i = P; i < S; i++) {
			answerCheck();
			if(dna_arr[i - P].equals("A")) count_arr[0]--;
			else if(dna_arr[i - P].equals("C")) count_arr[1]--;
			else if(dna_arr[i - P].equals("G")) count_arr[2]--;
			else count_arr[3]--;
			count(dna_arr[i]);
		}
		answerCheck();
		System.out.println(answer);
	}
	
	static void count(String p) {
		if(p.equals("A")) count_arr[0]++;
		else if(p.equals("C")) count_arr[1]++;
		else if(p.equals("G")) count_arr[2]++;
		else count_arr[3]++;
	}
	
	static void answerCheck() {
		int result_count = 0;
		for(int i = 0; i < 4;  i++) {
			if(condition[i] <= count_arr[i]) result_count++;
		}
		if(result_count == 4) answer++;
	}
}
