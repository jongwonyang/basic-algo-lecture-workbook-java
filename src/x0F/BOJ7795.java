package x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7795 {

    static int T, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(A);
            Collections.sort(B);

            int ans = 0;
            int j = 0;
            for (int i = 0; i < N; i++) {
                int a = A.get(i);

                while (true) {
                    if (j >= M) break;
                    int b = B.get(j);

                    if (a <= b) break;
                    j++;

                }

                ans += j;
            }

            System.out.println(ans);
        }
    }
}
