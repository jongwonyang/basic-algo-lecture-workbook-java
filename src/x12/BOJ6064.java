package x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064 {

    static int M, N, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            sb.append(solve()).append('\n');
        }
        System.out.println(sb);
    }

    static int solve() {
        if (x == M) x = 0;
        if (y == N) y = 0;
        int l = lcm(M, N);
        for (int i = x; i <= l; i += M) {
            if (i == 0) continue;
            if (i % N == y) return i;
        }
        return -1;
    }

    static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
