import java.util.Scanner;

public class Main {
	static int N;

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	int[] first = {2, 3, 5, 7}; //맨 앞자리는 무조건 2, 3, 5, 7이어야함
    	for(int i = 0; i < 4; i++) {
    		calc(first[i], 1);
    	}
  
    	
    	sc.close();
    }
    
    public static boolean is_prime(int n) {
    	for(int i = 2; i <= Math.sqrt(n); i++) {
    		if(n % i == 0) return false;
    	}
    	return true;
    }
    
    public static void calc (int n, int digit) {
    	if(digit > N) return; //오류방지용
    	//자리수 체크 N이 되면 list에 추가하기
    	if(digit == N) {
	    	System.out.println(n);
	    	return;
    	}
    	
    	//자리수 아직 모잘라면 calc돌리기
    	for(int i = 0; i <= 9; i++) {
    		if((n * 10 + i) % 2 == 0) continue; //짝수 거르기
    		if(is_prime(n * 10 + i)) {
    			calc(n * 10 + i, digit + 1);
    		}
    	}
    }    
}