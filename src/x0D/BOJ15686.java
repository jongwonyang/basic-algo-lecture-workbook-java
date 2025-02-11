package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {

    static int N, M;
    static int[][] board = new int[50][50];
    static List<Pair> home = new ArrayList<>();
    static List<Pair> chicken = new ArrayList<>();
    static int[] arr = new int[13];
    static boolean[] sel = new boolean[13];
    static int ans = Integer.MAX_VALUE;

    static void calc() {
        int sum = 0;
        for (Pair h : home) {
            int d = Integer.MAX_VALUE;
            for (int i = 0; i < M; i++) {
                Pair c = chicken.get(arr[i]);
                d = Math.min(d, Math.abs(c.x - h.x) + Math.abs(c.y - h.y));
            }
            sum += d;
        }
        ans = Math.min(ans, sum);
    }

    static void func(int idx, int st) {
        if (idx == M) {
            calc();
            return;
        }

        for (int i = st; i < chicken.size(); i++) {
            if (sel[i]) continue;
            arr[idx] = i;
            sel[i] = true;
            func(idx + 1, i + 1);
            sel[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
                if (board[x][y] == 1) home.add(new Pair(x, y));
                if (board[x][y] == 2) chicken.add(new Pair(x, y));
            }
        }

        func(0, 0);

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
