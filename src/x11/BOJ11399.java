package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {

    static int N;
    static int[] P = new int[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(P, 0, N);

        for (int i = 1; i < N; i++) P[i] = P[i - 1] + P[i];

        int ans = 0;
        for (int i = 0; i < N; i++) ans += P[i];
        System.out.println(ans);
    }
}
