import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger[][] combinations;
    static int total;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        // nCr = 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // a개수
        int M = Integer.parseInt(st.nextToken()); // z개수
        BigInteger K = new BigInteger(st.nextToken()); // k번째
        total = N + M;
        makeCombinations(total);
        sb = new StringBuilder();
        if (K.compareTo(combinations[total][N]) <= 0) {
            findString(N, M, K);
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    static void findString(int n, int m, BigInteger k) {
        while (total > 0) {
            total--;
            if (combinations[total][n - 1].compareTo(k) >= 0) {// 글자가 a일때
                sb.append("a");
                n--;
            } else {
                k = k.subtract(combinations[total][n - 1]);
                sb.append("z");
                m--;
            }
            if (n == 0 || m == 0)
                break;
        }
        while (n != 0) {
            sb.append("a");
            n--;
        }
        while (m != 0) {
            sb.append("z");
            m--;
        }
    }

    static void makeCombinations(int length) {
        combinations = new BigInteger[length + 1][length + 1];
        // 초기값설정
        for (int i = 1; i < length + 1; i++) {
            combinations[i][0] = BigInteger.ONE; // nC0 = 1이기 때문
            combinations[i][1] = BigInteger.valueOf(i); // nC1 = n이기 때문
            combinations[i][i] = BigInteger.ONE;
        }
        // nCr = n-1Cr + n-1Cr-1;
        for (int i = 2; i < length + 1; i++) {
            for (int j = 2; j < i; j++) {
                combinations[i][j] = combinations[i - 1][j].add(combinations[i - 1][j - 1]);
            }
        }
    }
}
