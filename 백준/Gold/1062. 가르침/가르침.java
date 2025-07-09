import java.io.*;
import java.util.*;

public class Main {
    static int N, K, answer;
    static int[] words;
    static boolean[] visited;
    public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
        
      if(K < 5) {
          System.out.println(0);
          return;
      }
        
      words = new int[N];
      visited = new boolean[26];
      visited['a' - 'a'] = true;
      visited['n' - 'a'] = true;
      visited['t' - 'a'] = true;
      visited['i' - 'a'] = true;
      visited['c' - 'a'] = true;
      for(int i = 0; i < N; i++) {
          String line = br.readLine();
          int bit = 0;
          for(char ch : line.toCharArray()) {
              bit |= (1 << (ch - 'a'));
          }
          words[i] = bit;
      }
      dfs(0, 0);
      System.out.println(answer);
    }
    static void dfs(int idx, int depth) {
        if(depth == K - 5) {
            int canRead = 0;
            for(int w : words) {
                boolean can = true;
                for (int i = 0; i < 26; i++) {
                    if ((w & (1 << i)) != 0 && !visited[i]) {
                        can = false;
                        break;
                    }
                }
                if (can) canRead++;
            }
            answer = Math.max(answer, canRead);
            return;
        }
        
        for(int i = idx; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}