package x12;

import java.util.Scanner;

public class BOJ11653 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int i = 2;
        StringBuilder sb = new StringBuilder();
        while (i * i <= N) {
            while (N % i == 0) {
                sb.append(i).append('\n');
                N /= i;
            }
            i++;
        }
        if (N != 1) sb.append(N);
        System.out.println(sb);
    }
}
