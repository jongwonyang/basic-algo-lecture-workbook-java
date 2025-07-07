package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15486 {

    static int N;
    static int[] T = new int[1500002];
    static int[] P = new int[1500002];
    static int[] D = new int[1500002]; // D[i] = i번째 일에 상담을 시작했을 때 최대 수익

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            if (i + T[i] <= N + 1) {
                D[i] = Math.max(P[i] + D[i + T[i]], D[i + 1]);
            } else {
                D[i] = D[i + 1];
            }
        }

        int ans = -1;
        for (int i = 1; i <= N; i++) ans = Math.max(ans, D[i]);
        System.out.println(ans);
    }
}
