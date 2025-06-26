package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {

    static int N;
    static int[] R = new int[1000];
    static int[] G = new int[1000];
    static int[] B = new int[1000];
    static int[][] dp = new int[1000][3]; // dp[i][j] = i번째 집까지 j 색으로 칠할 때 드는 최소 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = R[0];
        dp[0][1] = G[0];
        dp[0][2] = B[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G[i];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B[i];
        }

        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }
}
