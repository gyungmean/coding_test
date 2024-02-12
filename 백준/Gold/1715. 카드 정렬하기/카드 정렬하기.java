import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 : N - 카드 묶음의 수, 카드 묶음의 크기들
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> cards = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			cards.add(Integer.parseInt(br.readLine()));
		}
		int answer = 0;
		while(cards.size() != 1) {
			int newCard = cards.poll() + cards.poll();
			answer += newCard;
			cards.add(newCard);
		}
		System.out.println(answer);

	}

}