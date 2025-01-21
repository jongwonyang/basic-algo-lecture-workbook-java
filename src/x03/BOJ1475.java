package x03;

import java.util.Scanner;

public class BOJ1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cnt = new int[10];
        while (N > 0) {
            int num = N % 10;
            if (num == 6 || num == 9) {
                cnt[cnt[6] < cnt[9] ? 6 : 9]++;
            } else {
                cnt[num]++;
            }
            N /= 10;
        }
        int maxVal = -1;
        for (int i : cnt) maxVal = Math.max(maxVal, i);
        System.out.println(maxVal);
    }
}
