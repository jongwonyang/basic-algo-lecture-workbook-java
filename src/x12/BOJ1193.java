package x12;

import java.util.Scanner;

public class BOJ1193 {

    static int X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();

        int n = 1, m = 1;
        int dn = -1, dm = 1;
        int row = 1;
        for (int i = 1; i < X; i++) {
            int nxtn = n + dn;
            int nxtm = m + dm;

            if (nxtn == 0) {
                n = 1;
                m = ++row;
                dn *= -1;
                dm *= -1;
                continue;
            }

            if (nxtm == 0) {
                m = 1;
                n = ++row;
                dn *= -1;
                dm *= -1;
                continue;
            }

            n += dn;
            m += dm;
        }

        System.out.printf("%d/%d", n, m);
    }
}
