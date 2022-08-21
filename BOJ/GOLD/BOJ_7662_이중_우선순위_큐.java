package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662_이중_우선순위_큐 {

    static int T, k;
    static TreeMap<Integer, Integer> dpq = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            dpq.clear();
            k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (op) {
                    case "I":
                        put(num);
                        break;
                    case "D":
                        delete(num);
                        break;
                }
            }
            sb.append(print());
        }
        System.out.print(sb);
    }

    static void put(int num) {
        if (dpq.containsKey(num)) {
            dpq.put(num, dpq.get(num) + 1);
        } else {
            dpq.put(num, 1);
        }
    }

    static void delete(int num) {
        switch (num) {
            case 1:
                Map.Entry<Integer, Integer> last = dpq.lastEntry();
                operate(last);
                break;
            case -1:
                Map.Entry<Integer, Integer> first = dpq.firstEntry();
                operate(first);
                break;
        }
    }

    static void operate(Map.Entry<Integer, Integer> entry) {
        if (entry == null) return;

        if (entry.getValue() > 1) {
            dpq.put(entry.getKey(), entry.getValue() - 1);
        } else {
            dpq.remove(entry.getKey());
        }
    }

    static String print() {
        if (dpq.isEmpty()) {
            return "EMPTY\n";
        } else {
            return String.format("%d %d\n", dpq.lastKey(), dpq.firstKey());
        }
    }
}
