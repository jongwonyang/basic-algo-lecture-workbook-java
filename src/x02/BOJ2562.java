package x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxVal = 0, maxIdx = -1;
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > maxVal) {
                maxVal = num;
                maxIdx = i;
            }
        }
        System.out.println(maxVal);
        System.out.println(maxIdx + 1);
    }
}
