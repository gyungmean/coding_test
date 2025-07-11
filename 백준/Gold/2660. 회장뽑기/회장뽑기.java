import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[][] isFriend;
    static int[] point;
    static class Node {
        int idx;
        int count;
        public Node(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isFriend = new boolean[N + 1][N + 1];
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;
            isFriend[a][b] = true;
            isFriend[b][a] = true;
        }
        point = new int[N + 1];
        Arrays.fill(point, -1);
        for(int i = 1; i <= N; i++) {
            updatePoint(i);
        }
        //System.out.println(Arrays.toString(point));
        int score = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            score = Math.min(score, point[i]);
        }
        int count = 0;
        StringBuilder cand = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(point[i] == score) {
                count++;
                cand.append(i).append(" ");
            }
        }
        System.out.println(score + " " + count);
        System.out.println(cand);
        
    }
    
    static void updatePoint(int start) {
        Stack<Node> s = new Stack<>();
        s.push(new Node(start, 0));
        int[] tmp = new int[N + 1];
        Arrays.fill(tmp, Integer.MAX_VALUE);
        tmp[start] = 0;
        while(!s.isEmpty()) {
            Node now = s.pop();
            for(int i = 1; i <= N; i++) {
                if(i == now.idx) continue;
                if(isFriend[now.idx][i] && tmp[i] > now.count + 1) {
                    tmp[i] = now.count + 1;
                    s.push(new Node(i, now.count + 1));
                }
            }
        }
        int max = -1;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, tmp[i]);
        }
        point[start] = Math.max(point[start], max);
    }
}
