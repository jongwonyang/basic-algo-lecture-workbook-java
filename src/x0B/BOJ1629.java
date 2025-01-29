package x0B;

import java.util.Scanner;

public class BOJ1629 {

    static long func(long a, long b, long c) {
        if (b == 1) return a % c;
        long tmp = func(a, b / 2, c);
        tmp = tmp * tmp % c;
        if (b % 2 == 0) return tmp;
        else return tmp * a % c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        System.out.println(func(a, b, c));
    }
}
