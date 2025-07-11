package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {

    static int N, K;
    static int[] A = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            int cnt = K / A[i];
            ans += cnt;
            K -= A[i] * cnt;
        }
        System.out.println(ans);
    }
}
