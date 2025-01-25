package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1012 {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] board = new int[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            int ans = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (board[x][y] == 1) {
                        ans++;
                        Deque<Pair> q = new ArrayDeque<>();
                        q.offer(new Pair(x, y));
                        board[x][y] = 0;
                        while (!q.isEmpty()) {
                            Pair cur = q.poll();
                            for (int d = 0; d < 4; d++) {
                                int nx = cur.x + dx[d];
                                int ny = cur.y + dy[d];
                                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                                if (board[nx][ny] == 0) continue;
                                q.offer(new Pair(nx, ny));
                                board[nx][ny] = 0;
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
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
