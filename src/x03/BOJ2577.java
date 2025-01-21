package x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int num = a * b * c;

        int[] cnt = new int[10];
        while (num != 0) {
            cnt[num % 10]++;
            num /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : cnt) sb.append(i).append("\n");
        System.out.println(sb);
    }
}
