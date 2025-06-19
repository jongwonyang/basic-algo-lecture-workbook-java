package x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15688 {

    static int N;
    static int[] cnt = new int[2_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num + 1_000_000]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 2_000_000; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(i - 1_000_000).append('\n');
            }
        }
        System.out.println(sb);
    }
}
