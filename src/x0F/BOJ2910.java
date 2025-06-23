package x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2910 {

    static int N, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        List<Element> list = new ArrayList<>();
        Map<Integer, Integer> idx = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (idx.containsKey(num)) {
                list.get(idx.get(num)).cnt++;
            } else {
                idx.put(num, list.size());
                list.add(new Element(num, 1));
            }
        }

        Collections.sort(list, (o1, o2) -> Integer.compare(o2.cnt, o1.cnt));

        StringBuilder sb = new StringBuilder();
        for (Element e : list) {
            for (int i = 0; i < e.cnt; i++) {
                sb.append(e.num).append(' ');
            }
        }
        System.out.println(sb);
    }

    static class Element {
        int num;
        int cnt;
        public Element(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "num: " + num + ", " + "cnt: " + cnt;
        }
    }
}
