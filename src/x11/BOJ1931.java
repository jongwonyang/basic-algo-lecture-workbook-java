package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1931 {

    static int N;
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            list.add(new Pair(x, y));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.y != o2.y) return Long.compare(o1.y, o2.y);
            else return Long.compare(o1.x, o2.x);
        });

        long cur = 0;
        int ans = 0;
        for (Pair p : list) {
            if (cur > p.x) continue;
            cur = p.y;
            ans++;
        }
        System.out.println(ans);
    }

    static class Pair {
        long x, y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
