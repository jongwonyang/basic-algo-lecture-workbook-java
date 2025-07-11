package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1026 {

    static int N;
    static int[] A = new int[50];
    static int[] B = new int[50];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A, 0, N);
        Arrays.sort(B, 0, N);

        int ans = 0;
        for (int i = 0; i < N; i++) ans += A[i] * B[N - i - 1];
        System.out.println(ans);
    }
}
