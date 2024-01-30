import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int index = 0;
		int ans = 1;
		
		while(N != 1) {
			index = index + ans++;
			int r = 1 + 6 * index;
			if(r >= N) {break;}
		}
		
		System.out.println(ans);
		sc.close();
	}
}
