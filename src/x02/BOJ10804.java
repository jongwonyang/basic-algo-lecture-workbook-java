package x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[21];
        for (int i = 1; i <= 20; i++) arr[i] = i;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            while (a < b) {
                int tmp = arr[a];
                arr[a] = arr[b];
                arr[b] = tmp;
                a++;
                b--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 20; i++) sb.append(arr[i]).append(' ');
        System.out.println(sb);
    }
}
