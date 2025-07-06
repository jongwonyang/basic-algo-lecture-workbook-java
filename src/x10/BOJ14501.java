package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {

    static int N;
    static int[] T = new int[16];
    static int[] P = new int[16];
    static int[] D = new int[16]; // D[i] = i번째 상담을 마지막으로 했을 때 최대 수익

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        if (T[1] <= N) D[1] = P[1];
        for (int i = 2; i <= N; i++) {
            if (i + T[i] > N + 1) continue;
            D[i] = P[i];
            for (int j = 1; j < i; j++) {
                if (j + T[j] <= i) D[i] = Math.max(D[i], D[j] + P[i]);
            }
        }

        int ans = -1;
        for (int i = 1; i <= N; i++) ans = Math.max(ans, D[i]);
        System.out.println(ans);
    }
}
