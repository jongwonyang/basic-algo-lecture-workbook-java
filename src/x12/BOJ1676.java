package x12;

import java.util.Scanner;

public class BOJ1676 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int ans = 0;
        while (N >= 5) {
            ans += N / 5;
            N /= 5;
        }
        System.out.println(ans);
    }
}
