package x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        int cur = 0, ans = 0;
        char pre = '\0';
        for (char c : line) {
            if (c == '(') cur++;
            else {
                if (pre == '(') {
                    cur--;
                    ans += cur;
                } else {
                    ans++;
                    cur--;
                }
            }
            pre = c;
        }
        System.out.println(ans);
    }
}
