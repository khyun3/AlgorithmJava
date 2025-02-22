package BOJ.SILVER;

/*
문제
자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다.
이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오.
두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.

예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,
A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.

입력
첫째 줄에 집합 A의 원소의 개수와 집합 B의 원소의 개수가 빈 칸을 사이에 두고 주어진다.
둘째 줄에는 집합 A의 모든 원소가, 셋째 줄에는 집합 B의 모든 원소가 빈 칸을 사이에 두고 각각 주어진다.
각 집합의 원소의 개수는 200,000을 넘지 않으며, 모든 원소의 값은 100,000,000을 넘지 않는다.

출력
첫째 줄에 대칭 차집합의 원소의 개수를 출력한다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1269_대칭_차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int aCnt = Integer.parseInt(input[0]);
        int bCnt = Integer.parseInt(input[1]);

        //a입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<String> aSet = stringToSet(aCnt, st);

        //b입력
        st = new StringTokenizer(br.readLine(), " ");
        Set<String> bSet = stringToSet(bCnt, st);

        //대칭 차집합 개수 구하고  출력
        System.out.println(countSymmetricDifference(aSet, bSet, aCnt, bCnt));
    }

    static TreeSet<String> stringToSet(int cnt, StringTokenizer st) {
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < cnt; i++) {
            set.add(st.nextToken());
        }
        return set;
    }

    static int countSymmetricDifference(Set<String> aSet, Set<String> bSet, int aCnt, int bCnt) {
        int dupCnt = 0;
        for (String e : bSet) {
            //A-B
            if (aSet.contains(e)) {
                dupCnt++;
            }
        }
        return (aCnt - dupCnt) + (bCnt - dupCnt);
    }
}
