package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11053 {

    static int N;
    static int[] arr = new int[1001];
    static int[] D = new int[1001]; // D[i] = i번째 수를 마지막으로 하는 LIS의 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(D, 1, N + 1, 1);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i - 1; j++) {
                if (arr[j] < arr[i]) D[i] = Math.max(D[i], D[j] + 1);
            }
        }

        int ans = -1;
        for (int i = 1; i <= N; i++) ans = Math.max(ans, D[i]);
        System.out.println(ans);
    }
}
