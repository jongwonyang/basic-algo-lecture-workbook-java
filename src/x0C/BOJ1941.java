package x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ1941 {

    static char[][] board = new char[5][5];
    static int[] arr = new int[7];
    static boolean[] sel = new boolean[25];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int ans = 0;

    static void check() {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[5][5];
        q.offer(arr[0]);
        vis[arr[0] / 5][arr[0] % 5] = true;
        int cnt = 0;
        int cntS = 0;
        int cntY = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            int cx = cur / 5;
            int cy = cur % 5;
            if (board[cx][cy] == 'S') cntS++;
            else cntY++;
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int nn = nx * 5 + ny;
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (vis[nx][ny] || !sel[nn]) continue;
                q.offer(nn);
                vis[nx][ny] = true;
            }
        }
        if (cnt == 7 && cntS > cntY) ans++;
    }

    static void func(int idx, int st) {
        if (idx == 7) {
            check();
            return;
        }

        for (int i = st; i < 25; i++) {
            if (sel[i]) continue;
            arr[idx] = i;
            sel[i] = true;
            func(idx + 1, i + 1);
            sel[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int x = 0; x < 5; x++) {
            board[x] = br.readLine().toCharArray();
        }
        func(0, 0);
        System.out.println(ans);
    }
}
