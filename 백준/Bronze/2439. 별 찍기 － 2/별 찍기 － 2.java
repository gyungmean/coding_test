import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder st = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				st.append(" ");
			}
			for(int j = 0; j <= i; j++) {
				st.append("*");
			}
			System.out.println(st);
			st.setLength(0);
		}

	}

}
