import java.io.*;
import java.util.*;

public class Main {
    static class Info {
        int dest;
        long time; 
        public Info(int dest, long time) {
            this.dest = dest;
            this.time = time;
        }
    }

    final static long MAX_VALUE = Long.MAX_VALUE;
    static int N, M;
    static long[] times;
    static boolean[] canSee;
    static List<List<Info>> graph;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        canSee = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            canSee[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        canSee[N - 1] = false;

        graph = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Info(b, t));
            graph.get(b).add(new Info(a, t));
        }

        dijkstra();
        System.out.println(times[N - 1] == MAX_VALUE ? -1 : times[N - 1]);
    }

    static void dijkstra() {
        times = new long[N];
        Arrays.fill(times, MAX_VALUE);
        times[0] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(i -> i.time));
        pq.add(new Info(0, 0));

        while(!pq.isEmpty()) {
            Info now = pq.poll();
            if (now.time > times[now.dest]) continue;

            for(Info next : graph.get(now.dest)) {
  
                if (next.dest != N - 1 && canSee[next.dest]) continue;

                long newTime = now.time + next.time;
                if (newTime < times[next.dest]) {
                    times[next.dest] = newTime;
                    pq.add(new Info(next.dest, newTime));
                }
            }
        }
    }
}