package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();

        int ans = 0;
        int tmp = 0;
        int sign = 1;
        for (char c : str) {
            if (c == '-' || c == '+') {
                ans += tmp * sign;
                if (c == '-') sign = -1;
                tmp = 0;
            } else {
                tmp *= 10;
                tmp += c - '0';
            }
        }
        ans += tmp * sign;
        System.out.println(ans);
    }
}
