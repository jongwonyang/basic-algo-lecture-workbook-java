package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {

    static int N;
    static int[][] stat = new int[20][20];
    static int[] team = new int[20];
    static int ans = Integer.MAX_VALUE;

    static void game() {
        int[] score = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (team[i] == team[j])
                    score[team[i]] += stat[i][j];
            }
        }
        int diff = Math.abs(score[0] - score[1]);
        ans = Math.min(ans, diff);
    }

    static void func(int idx, int cnt) {
        if (idx == N) {
            if (cnt == N / 2) {
                game();
            }
            return;
        }

        team[idx] = 0;
        func(idx + 1, cnt);
        team[idx] = 1;
        func(idx + 1, cnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0);

        System.out.println(ans);
    }
}
