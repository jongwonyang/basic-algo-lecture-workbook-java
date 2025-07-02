package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055 {

    static int N;
    static int[] arr = new int[1001];
    static int[] D = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int maxval = 0;
            for (int j = 1; j <= i - 1; j++) {
                if (arr[j] < arr[i] && maxval < D[j]) {
                    maxval = D[j];
                }
            }
            D[i] = maxval + arr[i];
        }

        int ans = -1;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, D[i]);
        }
        System.out.println(ans);
    }
}
