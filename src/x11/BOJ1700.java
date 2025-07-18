package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1700 {

    static int N, K;
    static int[] seq = new int[101]; // seq[i] = i번째 사용할 제품의 번호
    static boolean[] use = new boolean[101]; // use[i] = i번 제품이 꽂혀있는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int cnt = 0; // 꽂혀 있는 제품 개수
        for (int i = 1; i <= K; i++) {
            int cur = seq[i];

            // 이미 꽂혀 있음
            if (use[cur]) continue;

            // 남은 자리가 있음
            if (cnt < N) {
                use[cur] = true;
                cnt++;
                continue;
            }

            List<Pair> idx = new ArrayList<>(); // { 제품, 다음에 나올 순서 }
            for (int x = 1; x <= K; x++) {
                if (!use[x]) continue;
                boolean vis = false;
                for (int y = i + 1; y <= K; y++) {
                    if (seq[y] == x) {
                        idx.add(new Pair(x, y));
                        vis = true;
                        break;
                    }
                }
                if (!vis) idx.add(new Pair(x, K + 1));
            }
            Collections.sort(idx, (p1, p2) -> Integer.compare(p2.y, p1.y));
            int target = idx.get(0).x;
            use[target] = false;
            use[cur] = true;
            ans++;
        }

        System.out.println(ans);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
