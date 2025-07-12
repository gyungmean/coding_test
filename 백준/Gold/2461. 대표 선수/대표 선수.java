import java.io.*;
import java.util.*;

class Main {
    static class Node implements Comparable<Node> {
        int value, row, col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] student = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                student[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(student[i]);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            pq.offer(new Node(student[i][0], i, 0));
            max = Math.max(max, student[i][0]);
        }

        int answer = Integer.MAX_VALUE;

        while (true) {
            Node minNode = pq.poll(); 

            answer = Math.min(answer, max - minNode.value);

            if (minNode.col + 1 == M) break; 

            int nextVal = student[minNode.row][minNode.col + 1];
            pq.offer(new Node(nextVal, minNode.row, minNode.col + 1));
            max = Math.max(max, nextVal);
        }

        System.out.println(answer);
    }
}