package x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9613 {

    static int N;
    static int[] arr = new int[101];
    static int[] sel = new int[2];
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            ans = 0;
            func(0, 0, 0);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void func(int st, int idx, int cnt) {
        if (cnt == 2) {
            // GCD 계산
            ans += gcd(sel[0], sel[1]);
            return;
        }

        for (int i = st; i < N; i++) {
            sel[idx] = arr[i];
            func(i + 1, idx + 1, cnt + 1);
        }
    }

    static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
