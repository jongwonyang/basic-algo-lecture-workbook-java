package x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816 {

    static int N, M;
    static int[] arr = new int[500001];
    static int[] target = new int[500001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) target[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int lo = lowerBound(target[i]);
            int up = upperBound(target[i]);
            sb.append(up - lo).append(' ');
        }
        System.out.println(sb);
    }

    static int lowerBound(int target) {
        int st = 0, en = N;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] >= target) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    static int upperBound(int target) {
        int st = 0, en = N;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] > target) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}
