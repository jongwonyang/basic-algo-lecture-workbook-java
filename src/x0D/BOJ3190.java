package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ3190 {

    static int N, K, L, d = 0;
    static int[][] board = new int[100][100]; // 1: 뱀, 2: 사과
    static char[] turn = new char[10001];
    static Deque<Pair> dq = new ArrayDeque<>();

    static final int[] dx = { 0, 1, 0, -1 };
    static final int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 2;
        }
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            turn[x] = c;
        }

        board[0][0] = 1;
        dq.addLast(new Pair(0, 0));

        int t = 1;
        while (true) {
            Pair head = dq.getFirst();
            int nx = head.x + dx[d];
            int ny = head.y + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
            if (board[nx][ny] == 1) break;
            if (board[nx][ny] == 0)  {
                Pair tail = dq.removeLast();
                board[tail.x][tail.y] = 0;
            }
            board[nx][ny] = 1;
            dq.addFirst(new Pair(nx, ny));
            if (turn[t] == 'L') d = (d + 3) % 4;
            if (turn[t] == 'D') d = (d + 1) % 4;
            t++;
        }
        System.out.println(t);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
