package x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1476 {

    static int E, S, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // N % 15 = E (0 이면 15)
        // N % 28 = S (0 이면 28)
        // N % 19 = M (0 이면 19)
        int N = E;
        while (true) {
            int s = N % 28 == 0 ? 28 : N % 28;
            if (s == S) break;
            N += 15;
        }

        int l = lcm(15, 28);
        while (true) {
            int m = N % 19 == 0 ? 19 : N % 19;
            if (m == M) break;
            N += l;
        }
        System.out.println(N);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) return b;
        return gcd(b, r);
    }
}
