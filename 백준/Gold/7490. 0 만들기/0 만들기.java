import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] op;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            op = new int[n - 1];
            permutation(0);
            if (tc < t - 1) sb.append("\n");
        }
        System.out.println(sb);
    }

    static void permutation(int cnt) {
        if (cnt == n - 1) {
            calculateAndPrint();
            return;
        }

        for (int i = 1; i <= 3; i++) {
            op[cnt] = i;
            permutation(cnt + 1);
        }
    }

    static void calculateAndPrint() {
        int sum = 0;
        int currentNumber = 1;
        int sign = 1;
        StringBuilder tmp = new StringBuilder();
        tmp.append(1);

        for (int idx = 0, num = 2; num <= n; num++, idx++) {
            if (op[idx] == 2) {
                sum += sign * currentNumber;
                sign = 1;
                currentNumber = num;
                tmp.append("+").append(num);
            } else if (op[idx] == 3) {
                sum += sign * currentNumber;
                sign = -1;
                currentNumber = num;
                tmp.append("-").append(num);
            } else if (op[idx] == 1) {
                currentNumber = currentNumber * 10 + num;
                tmp.append(" ").append(num);
            }
        }
        sum += sign * currentNumber;

        if (sum == 0) {
            sb.append(tmp).append("\n");
        }
    }
}