package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9466 {

    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            int[] state = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                if (state[i] == NOT_VISITED) {
                    int cur = i;
                    while (true) {
                        if (state[cur] == NOT_VISITED) {
                            state[cur] = i;
                            cur = arr[cur];
                        } else {
                            if (state[cur] == i) {
                                while (state[cur] != CYCLE_IN) {
                                    state[cur] = CYCLE_IN;
                                    cur = arr[cur];
                                }
                            }
                            break;
                        }
                    }
                }
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (state[i] != CYCLE_IN) ans++;
            }
            System.out.println(ans);
        }
    }
}
