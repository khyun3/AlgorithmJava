package SPROUT;

import java.util.Scanner;
//GPA = Grade Point Average 평점
public class BOJ_2754_학점계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char [] input = sc.next().toCharArray();
        System.out.println(calcGrade(input));
    }
    static double calcGrade(char [] grade) {
        double res = 0.0d;
        switch (grade[0]){
            case 'F':
                break;
            default:
                res +=Math.abs(grade[0] - 69);
                res += grade[1] == '+' ? 0.3
                        : grade[1] =='-' ? -0.3 : 0.0;
                break;
        }
        return res;
    }
}