package x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11728 {

    static int N, M;
    static int[] A = new int[1000001];
    static int[] B = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int ia = 0;
        int ib = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (ia >= N && ib >= M) break;
            if (ia >= N) {
                sb.append(B[ib++]).append(' ');
                continue;
            }
            if (ib >= M) {
                sb.append(A[ia++]).append(' ');
                continue;
            }
            if (A[ia] > B[ib]) {
                sb.append(B[ib++]).append(' ');
            } else {
                sb.append(A[ia++]).append(' ');
            }
        }
        System.out.println(sb);
    }
}
