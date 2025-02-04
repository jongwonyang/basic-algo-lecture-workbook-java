package x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {

    static int N, S;
    static int[] arr = new int[20];
    static int ans = 0;

    static void func(int idx, int sum) {
        if (idx == N) {
            if (sum == S) ans++;
            return;
        }

        func(idx + 1, sum);
        func(idx + 1, sum + arr[idx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        func(0, 0);

        if (S == 0) ans--;
        System.out.println(ans);
    }
}
