import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int n1 = (N % 10) * 10;
		int n2 = ((N % 10) + (N / 10)) % 10;
		int sum = n1 + n2;
		int count = 1;
		while(sum != N) {
			n1 = (sum % 10) * 10;
			n2 = ((sum % 10) + (sum / 10)) % 10;
			sum = n1 + n2;
			count++;
		}
		System.out.println(count);

	}

}
