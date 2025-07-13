package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2457 {

    static int N;
    static List<Flower> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            list.add(new Flower(sm, sd, em, ed));
        }

        int cur = 301;
        int ans = 0;
        while (true) {
            int nxt = cur;
            for (Flower f : list) {
                if (f.st <= cur && f.ed > nxt) {
                    nxt = f.ed;
                }
            }
            if (nxt == cur) {
                ans = 0;
                break;
            }
            cur = nxt;
            ans++;
            if (cur > 1130) break;
        }
        System.out.println(ans);
    }

    static class Flower {
        int st, ed;

        public Flower(int sm, int sd, int em, int ed) {
            this.st = sm * 100 + sd;
            this.ed = em * 100 + ed;
        }
    }
}
