package x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3273 {
    static int MX = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] occur = new boolean[MX + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            occur[Integer.parseInt(st.nextToken())] = true;
        }
        int X = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 1; i <= MX; i++) {
            if (X - i < 1 || X - i > MX) continue;
            if (occur[i] && occur[X - i]) ans++;
        }
        System.out.println(ans >> 1);
    }
}
