package x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

    static int N, M;
    static int[] A = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Arrays.sort(A, 0, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(n)).append('\n');
        }
        System.out.println(sb);
    }

    static int binarySearch(int n) {
        int st = 0, en = N - 1;
        while (st <= en) {
            int mid = (st + en) / 2;
            if (n < A[mid]) {
                en = mid - 1;
                continue;
            }
            if (A[mid] < n) {
                st = mid + 1;
                continue;
            }
            return 1;
        }
        return 0;
    }
}
