package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ5427 {

    static int W, H;
    static char[][] board;
    static Deque<Pair> qS, qF;
    static int[][] distS, distF;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            board = new char[H][W];
            qS = new ArrayDeque<>();
            qF = new ArrayDeque<>();
            distS = new int[H][W];
            distF = new int[H][W];

            for (int x = 0; x < H; x++) {
                char[] line = br.readLine().toCharArray();
                for (int y = 0; y < W; y++) {
                    board[x][y] = line[y];
                    if (board[x][y] == '@') {
                        qS.offer(new Pair(x, y));
                        distS[x][y] = 1;
                    }
                    if (board[x][y] == '*') {
                        qF.offer(new Pair(x, y));
                        distF[x][y] = 1;
                    }
                }
            }

            while (!qF.isEmpty()) {
                Pair cur = qF.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                    if (board[nx][ny] == '#' || distF[nx][ny] != 0) continue;
                    qF.offer(new Pair(nx, ny));
                    distF[nx][ny] = distF[cur.x][cur.y] + 1;
                }
            }

            boolean esc = false;
            while (!qS.isEmpty()) {
                Pair cur = qS.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                        System.out.println(distS[cur.x][cur.y]);
                        esc = true;
                        break;
                    }
                    if (board[nx][ny] == '#' || distS[nx][ny] != 0) continue;
                    if (distF[nx][ny] != 0 && distF[nx][ny] <= distS[cur.x][cur.y] + 1) continue;
                    qS.offer(new Pair(nx, ny));
                    distS[nx][ny] = distS[cur.x][cur.y] + 1;
                }
                if (esc) break;
            }

            if (!esc) System.out.println("IMPOSSIBLE");
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
