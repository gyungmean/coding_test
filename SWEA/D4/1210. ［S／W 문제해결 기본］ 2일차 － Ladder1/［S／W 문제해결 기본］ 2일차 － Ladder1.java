import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	
    //2에서부터 올라가기
    //입력 : 테케 번호, 배열
    //출력 : 출발점 x좌표
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int T = 1; T <= 10; T++) {
			int test_case = Integer.parseInt(br.readLine());
			int[][] ladder = new int[100][100];
			int now = 0;
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < 100; i++) {
				if(ladder[99][i] == 2) {
					now = i;
				}
			}
			for(int i = 98; i >= 0; i--) {
				//좌우확인
				if(check(now - 1) && ladder[i][now - 1] == 1) {
					while(check(now - 1) && ladder[i][now - 1] == 1)
						now--;
				} else if(check(now + 1) && ladder[i][now + 1] == 1) {
					while(check(now + 1) && ladder[i][now + 1] == 1)
						now++;
				}
			}
			System.out.println("#" + test_case + " " + now);

		}
	}
	public static boolean check(int n) {
		if(n < 0 || n >= 100) return false;
		return true;
	}
}