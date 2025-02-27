package BOJ.BRONZE;


/*
문제
영선이는 길이가 a, b, c인 세 막대를 가지고 있고, '각 막대의 길이를 마음대로 줄일 수 있다.'

영선이는 세 막대를 이용해서 아래 조건을 만족하는 삼각형을 만들려고 한다.
1. 각 막대의 길이는 양의 정수이다
2. 세 막대를 이용해서 넓이가 양수인 삼각형을 만들 수 있어야 한다.
3. 삼각형의 둘레를 최대로 해야 한다.

a, b, c가 주어졌을 때, 만들 수 있는 가장 큰 둘레를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 a, b, c (1 ≤ a, b, c ≤ 100)가 주어진다.

출력
첫째 줄에 만들 수 있는 가장 큰 삼각형의 둘레를 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14215_세_막대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        System.out.println(makeBiggestTriangle(a, b, c));
    }

    static int makeBiggestTriangle(int a, int b, int c) {
        //삼각형의 세 변의 합 정의 :
        //(a + b > c) && (a + c > b) && (b + c > a)
        //풀이 :
        // 만약 위 3가지 식의 정의중 만족하지 않는 것이 있다면,
        // 해당 변의 길이를 나머지 두 변의 길이의 합 - 1 까지 줄이면 된다.
        if (a + b <= c) {
            c = a + b - 1;
        } else if (a + c <= b) {
            b = a + c - 1;
        } else if (b + c <= a) {
            a = b + c - 1;
        }

        return a + b + c;
    }
}
