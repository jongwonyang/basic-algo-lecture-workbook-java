package x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        if (a == b) {
            System.out.println(0);
            return;
        }
        if (a > b) {
            long tmp = a;
            a = b;;
            b = tmp;
        }
        System.out.println(b - a - 1);
        StringBuilder sb = new StringBuilder();
        for (long i = a + 1; i < b; i++) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}
