package x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ5648 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line).append(' ');
        }

        StringTokenizer st = new StringTokenizer(sb.toString());
        N = Integer.parseInt(st.nextToken());

        List<Long> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            long num = Long.parseLong(new StringBuilder(st.nextToken()).reverse().toString());
            list.add(num);
        }
        Collections.sort(list);

        StringBuilder ans = new StringBuilder();
        for (long n : list) ans.append(n).append('\n');
        System.out.println(ans);
    }
}
