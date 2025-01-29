package x0B;

import java.util.Scanner;

public class BOJ1074 {

    static int func(int n, int r, int c) {
        if (n == 1) {
            return 2 * r + c;
        }
        int pre = 0;
        int half = (1 << (n - 1));
        int quarter = half * half;
        if (r >= half) {
            pre += quarter + quarter;
            r -= half;
        }
        if (c >= half) {
            pre += quarter;
            c -= half;
        }
        return pre + func(n - 1, r, c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(func(N, r, c));
    }
}
