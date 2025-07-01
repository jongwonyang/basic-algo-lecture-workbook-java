package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {

    static int N;
    static int[] arr = new int[100001];
    static int[] D = new int[100001]; // D[i] = i번째 수를 마지막으로 하는 최대 연속합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        D[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            D[i] = Math.max(0, D[i - 1]) + arr[i];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, D[i]);
        }
        System.out.println(ans);
    }
}
