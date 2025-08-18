package x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18870 {

    static int N;
    static int[] tmp = new int[1_000_001];
    static int[] uni = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tmp[i] = uni[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(uni, 0, N);

        int k = 1;
        for (int i = 1; i < N; i++) {
            if (uni[i] == uni[k - 1]) continue;
            uni[k++] = uni[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(Arrays.binarySearch(uni, 0, k, tmp[i])).append(' ');
        }
        System.out.println(sb);

    }
}
