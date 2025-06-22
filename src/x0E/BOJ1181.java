package x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1181 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);

        Collections.sort(list, (o1, o2) -> {
            if (o1.length() != o2.length())
                return Integer.compare(o1.length(), o2.length());
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str).append('\n');
        }
        System.out.println(sb);
    }
}
