package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2170 {

    static int N;
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Pair(x, y));
        }

        Collections.sort(list, (p1, p2) -> {
            if (p1.x == p2.x) return Integer.compare(p1.y, p2.y);
            return Integer.compare(p1.x, p2.x);
        });

        list.add(new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE));

        long ans = 0;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        for (Pair p : list) {
            if (p.x > right) {
                ans += right - left;
                left = p.x;
            }
            right = Math.max(right, p.y);
        }
        System.out.println(ans);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
