package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217 {

    static int N;
    static int[] arr = new int[100000];
    static int[] W = new int[100001]; // W[i] = 로프를 i개 골랐을 때 최대 중량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 0, N);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, arr[N - i] * i);
        }
        System.out.println(ans);
    }
}
