package x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int[] cnt = new int['z' - 'a' + 1];
        for (char c : line.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : cnt) sb.append(i).append(' ');
        System.out.println(sb);
    }
}
