package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15685 {

    static final int[] dx = { 1, 0, -1, 0 };
    static final int[] dy = { 0, -1, 0, 1 };

    static boolean[][] board = new boolean[101][101];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> mv = new ArrayList<>();
            mv.add(d);

            for (int j = 0; j < g; j++) {
                int len = mv.size();
                for (int k = len - 1; k >= 0; k--) {
                    int cur = mv.get(k);
                    int nxt = (cur + 1) % 4;
                    mv.add(nxt);
                }
            }

            board[x][y] = true;
            for (int m : mv) {
                x += dx[m];
                y += dy[m];
                board[x][y] = true;
            }
        }

        for (int cx = 0; cx <= 99; cx++) {
            for (int cy = 0; cy <= 99; cy++) {
                if (board[cx][cy] && board[cx + 1][cy] && board[cx][cy + 1] && board[cx + 1][cy + 1]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
