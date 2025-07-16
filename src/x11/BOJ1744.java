package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1744 {

    static int N;
    static List<Integer> pos = new ArrayList<>();
    static List<Integer> neg = new ArrayList<>();
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 1) ans++;
            else if (n > 0) pos.add(n);
            else neg.add(n);
        }

        Collections.sort(pos);
        Collections.sort(neg, (o1, o2) -> Integer.compare(o2, o1));

        sum(pos);
        sum(neg);

        System.out.println(ans);
    }

    static void sum(List<Integer> list) {
        while (1 < list.size()) {
            int a = list.remove(list.size() - 1);
            int b = list.remove(list.size() - 1);
            ans += a * b;
        }

        if (!list.isEmpty()) ans += list.get(0);
    }
}
