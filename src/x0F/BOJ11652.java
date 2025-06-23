package x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ11652 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Long> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(list);

        int curCnt = 1;
        int maxCnt = 1;
        long maxVal = list.get(0);
        for (int i = 1; i < N; i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                curCnt++;
            } else {
                if (curCnt > maxCnt) {
                    maxCnt = curCnt;
                    maxVal = list.get(i - 1);
                }
                curCnt = 1;
            }
        }
        if (curCnt > maxCnt) maxVal = list.get(N - 1);

        System.out.println(maxVal);
    }
}
