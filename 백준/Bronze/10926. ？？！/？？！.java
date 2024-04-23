import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String id = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append(id).append("??!");
		System.out.println(sb);

	}

}