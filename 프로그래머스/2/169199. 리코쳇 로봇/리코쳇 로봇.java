import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    int r, c;
    char[][] map;

    public int solution(String[] board) {
        int startX = 0;
        int startY = 0;

        r = board.length;
        c = board[0].length();

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = board[i].charAt(j);

                if (map[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }

        return move(startX, startY);
    }

    int move(int x, int y) {
        Queue<Info> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];

        q.offer(new Info(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Info now = q.poll();

            if (map[now.x][now.y] == 'G') {
                return now.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x;
                int ny = now.y;

                // 벽(D)이나 범위 밖을 만날 때까지 미끄러짐
                while (true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];

                    if (!boundCheck(tx, ty) || map[tx][ty] == 'D') {
                        break;
                    }

                    nx = tx;
                    ny = ty;
                }

                // 제자리면 스킵
                if (nx == now.x && ny == now.y) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Info(nx, ny, now.count + 1));
                }
            }
        }

        return -1;
    }

    boolean boundCheck(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }
}

class Info {
    int x;
    int y;
    int count;

    public Info(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}