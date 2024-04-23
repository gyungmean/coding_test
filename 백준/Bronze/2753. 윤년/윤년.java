import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		boolean isLeap = false;
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			isLeap = true;
		}
		System.out.println(isLeap ? 1 : 0);

	}

}
