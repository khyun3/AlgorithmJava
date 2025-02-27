package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
문제
창영이는 삼각형의 종류를 잘 구분하지 못한다. 따라서 프로그램을 이용해 이를 외우려고 한다.

삼각형의 세 각을 입력받은 다음,

세 각의 크기가 모두 60이면, Equilateral
세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
세 각의 합이 180이 아닌 경우에는 Error
를 출력하는 프로그램을 작성하시오.

입력
총 3개의 줄에 걸쳐 삼각형의 각의 크기가 주어진다. 모든 정수는 0보다 크고, 180보다 작다.

출력
문제의 설명에 따라 Equilateral, Isosceles, Scalene, Error 중 하나를 출력한다.

*/
public class BOJ_10101_삼각형_외우기 {
    private static final int TRIANGLE_SUM = 180;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int angleA = Integer.parseInt(br.readLine());
        int angleB = Integer.parseInt(br.readLine());
        int angleC = Integer.parseInt(br.readLine());
        System.out.println(classifyTriangle(angleA, angleB, angleC));
    }

    static String classifyTriangle(int angleA, int angleB, int angleC) {
        int totalAngle = angleA + angleB + angleC;
        if (totalAngle != TRIANGLE_SUM) {
            return "Error";
        }

        if (angleA == angleB && angleA == angleC) {
            return "Equilateral";
        } else if (angleA == angleB || angleA == angleC || angleB == angleC) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
}