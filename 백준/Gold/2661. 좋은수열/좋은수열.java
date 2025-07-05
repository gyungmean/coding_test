import java.util.*;
import java.io.*;
public class Main {

    static int N;
    static int[] arr;
    static StringBuilder answer, tmp, add;
    static boolean found;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        answer = new StringBuilder();
        arr = new int[N];
        arr[0] = 1;
        fillArr(1);
        System.out.println(answer);
    }
    static void fillArr(int idx) {
        if(found) return;
        if(idx == N) {
            for(int n : arr) answer.append(n);
            found = true;
            return;
        }
        
        for(int n = 1; n <= 3; n++) {
            //isGood? 진행
            arr[idx] = n;
            if(isGood(idx)) fillArr(idx + 1);
        }
    }
    
    static boolean isGood(int idx) {
        for(int len = 1; len <= (idx + 1) / 2; len++) {
            boolean isSame = true;
            for(int i = 0; i < len; i++) {
                if(arr[idx - i] != arr[idx - len - i]) {
                    isSame = false;
                    break;
                }
            }
            if(isSame) return false;
        }
        return true;
    }
}