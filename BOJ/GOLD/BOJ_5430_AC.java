package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
//TODO : 속도 1000ms걸림 다시 풀 때, 400ms로 낮출 것
public class BOJ_5430_AC {
    static LinkedList<Integer> deq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char [] p = br.readLine().replaceAll("(RR)", "").toCharArray(); //명령어 순서
            deq = new LinkedList<>();
            Integer.parseInt(br.readLine());
            String x = br.readLine().replaceAll("[\\[\\]]", "");
            initXn(x);
            sb.append(operate(p)).append("\n");
        }
        System.out.print(sb);
    }

    static String operate(char [] p) {
        boolean order = true;
        for (int i = 0; i < p.length; i++) {
            char nextOp = p[i];
                switch (nextOp){
                    case 'R':
                        order = !order;
                        break;
                    case 'D':
                        if(!remove(order)){
                            return "error";
                        }
                        break;
                }
        }
        return result(order);
    }
    static String result(boolean order) {
        if (!order) {
            Collections.reverse(deq);
        }
        return deq.toString().replaceAll("\\s", "");
    }
    static boolean remove(boolean order) {
        if(deq.isEmpty()) {
            return false;
        }
        if(order) {
            deq.removeFirst();
        }
        else {
            deq.removeLast();
        }
        return true;
    }
    static void initXn(String x) {
        StringTokenizer st = new StringTokenizer(x, ",");
        while(st.hasMoreTokens()) {
            deq.add(Integer.parseInt(st.nextToken()));
        }
    }
}
