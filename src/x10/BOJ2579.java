package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

    static int N;
    static int[] arr = new int[301];
    static int[][] dp = new int[301][3]; // dp[i][j] = i번째 계단을 밟을 때, 연속 j번 계단을 밟게되는 경우 최대 점수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0][1] = arr[0];
        dp[0][2] = -1;
        dp[1][1] = arr[1];
        dp[1][2] = arr[0] + arr[1];
        for (int i = 2; i < N; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + arr[i];
            dp[i][2] = dp[i - 1][1] + arr[i];
        }

        System.out.println(Math.max(dp[N - 1][1], dp[N - 1][2]));
    }
}
