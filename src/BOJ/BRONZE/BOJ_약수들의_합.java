package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.
    예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.
    n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.

*/
public class BOJ_약수들의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int number = Integer.parseInt(br.readLine());
            if(number == -1) break;

            int divisorSum = 1;
            int divisorMax = number / 2;
            StringBuilder divisor = new StringBuilder(" 1 + ");

            //1. 약수 구하고 약수의 총 합에 더한다.
            for (int i = 2; i <= divisorMax; i++) {
                if (number % i == 0) {
                    divisorSum += i;
                    divisor.append(i).append(" + ");
                }
            }
            //2. 테스트 케이스의 정답을 추가한다.
            divisor = divisor.delete(divisor.length() - 3, divisor.length());
            sb.append(makeAnswer(number, divisor.toString(), divisorSum));
        }
        //3. 정답을 출력한다.
        System.out.println(sb);
    }

    static String makeAnswer(int number, String divisors, int divisorSum) {
        if (number == divisorSum) {
            return divisorSum + " =" + divisors + "\n";
        } else {
            return number + " is NOT perfect.\n";
        }
    }
}
