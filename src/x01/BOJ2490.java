package x01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = 0;
            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(st.nextToken()) == 0) zero++;
            }
            if (zero == 1) System.out.println("A");
            else if (zero == 2) System.out.println("B");
            else if (zero == 3) System.out.println("C");
            else if (zero == 4) System.out.println("D");
            else System.out.println("E");
        }
    }
}
