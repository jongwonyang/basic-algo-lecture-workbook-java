package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ7562 {

    static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int L = Integer.parseInt(br.readLine());
            int[][] board = new int[L][L];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            Deque<Pair> q = new ArrayDeque<>();
            q.offer(new Pair(sx, sy));
            board[sx][sy] = 1;

            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx < 0 || nx >= L || ny < 0 || ny >= L) continue;
                    if (board[nx][ny] != 0) continue;
                    q.offer(new Pair(nx, ny));
                    board[nx][ny] = board[cur.x][cur.y] + 1;
                }
            }

            System.out.println(board[tx][ty] - 1);
        }
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
