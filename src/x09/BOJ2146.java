package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2146 {

    static int N;
    static int[][] board = new int[100][100];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int x = 0; x < N; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] vis = new boolean[N][N];
        int island = 1;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (board[x][y] != 0 && !vis[x][y]) {
                    Deque<Pair> q = new ArrayDeque<>();
                    q.offer(new Pair(x, y));
                    vis[x][y] = true;
                    while (!q.isEmpty()) {
                        Pair cur = q.poll();
                        board[cur.x][cur.y] = island;
                        for (int d = 0; d < 4; d++) {
                            int nx = cur.x + dx[d];
                            int ny = cur.y + dy[d];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if (board[nx][ny] == 0 || vis[nx][ny]) continue;
                            q.offer(new Pair(nx, ny));
                            vis[nx][ny] = true;
                        }
                    }
                    island++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (board[x][y] != 0) {
                    int s = board[x][y];
                    Deque<Pair> q = new ArrayDeque<>();
                    int[][] dist = new int[N][N];
                    q.offer(new Pair(x, y));
                    dist[x][y] = 1;
                    boolean found = false;
                    while (!q.isEmpty()) {
                        Pair cur = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = cur.x + dx[d];
                            int ny = cur.y + dy[d];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if (dist[nx][ny] != 0 || board[nx][ny] == s) continue;
                            if (board[nx][ny] != 0) {
                                ans = Math.min(ans, dist[cur.x][cur.y] - 1);
                                found = true;
                                break;
                            }
                            q.offer(new Pair(nx, ny));
                            dist[nx][ny] = dist[cur.x][cur.y] + 1;
                        }
                        if (found) break;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}