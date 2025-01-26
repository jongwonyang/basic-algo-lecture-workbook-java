package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2573 {

    static int N, M;
    static int[][] board = new int[300][300];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 1;
        while (true) {
            int[][] dBoard = new int[N][M];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (board[x][y] != 0) {
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if (board[nx][ny] == 0) dBoard[x][y]--;
                        }
                    }
                }
            }

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    board[x][y] += dBoard[x][y];
                    board[x][y] = Math.max(board[x][y], 0);
                }
            }

            boolean[][] vis = new boolean[N][M];
            int cnt = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (board[x][y] != 0 && !vis[x][y]) {
                        cnt++;
                        Deque<Pair> q = new ArrayDeque<>();
                        q.offer(new Pair(x, y));
                        vis[x][y] = true;
                        while (!q.isEmpty()) {
                            Pair cur = q.poll();
                            for (int d = 0; d < 4; d++) {
                                int nx = cur.x + dx[d];
                                int ny = cur.y + dy[d];
                                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                                if (board[nx][ny] == 0 || vis[nx][ny]) continue;
                                q.offer(new Pair(nx, ny));
                                vis[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            if (cnt >= 2) {
                System.out.println(ans);
                return;
            } else if (cnt == 0) {
                System.out.println(0);
                return;
            }
            ans++;
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
