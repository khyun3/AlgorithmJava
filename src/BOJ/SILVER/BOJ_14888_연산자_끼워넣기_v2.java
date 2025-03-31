package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14888_연산자_끼워넣기_v2 {
    static int N, min = Integer.MAX_VALUE, max = -Integer.MAX_VALUE;
    static int[] inputNum, opCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inputNum = new int[N];
        opCount = new int[4]; //+,-,*,/

        //수 입력 받기
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            inputNum[i] = Integer.parseInt(str[i]);
        }

        //연산자 개수 입력 받기
        String[] opCountInput = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            opCount[i] = Integer.parseInt(opCountInput[i]);
        }

        //연산자 순열을 생성하고 계산 수행
        dfs(0, new int[N - 1]);
        System.out.println(max + "\n" + min);
    }

    // 연산자 조합을 만들고 계산하는 함수
    static void dfs(int index, int[] selectedOperators) {
        if (index == N - 1) {
            int result = calc(selectedOperators);
            min = Math.min(result, min);
            max = Math.max(result, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opCount[i] > 0) {
                //현재 연산자를 선택하고, 그 연산자를 사용했다고 표시한다.
                opCount[i]--;
                selectedOperators[index] = i; //연산자의 index를 저장한다.
                dfs(index + 1, selectedOperators);
                opCount[i]++; //재귀 호출 후 복원
            }
        }
    }

    // 선택된 연산자 배열을 기반으로 결과를 계산하는 함수
    static int calc(int[] selectedOperators) {
        int result = inputNum[0];
        for (int i = 1; i < N; i++) {
            switch (selectedOperators[i - 1]) {
                case 0:
                    result += inputNum[i];
                    break;
                case 1:
                    result -= inputNum[i];
                    break;
                case 2:
                    result *= inputNum[i];
                    break;
                case 3:
                    result = divide(result, inputNum[i]);
            }
        }
        return result;
    }

    //C++ 나누기 대응
    static int divide(int a, int b) {
        if (a < 0 && b > 0) return -(-a / b);
        else if (a > 0 && b < 0) return -(a / b);
        else return a / b;
    }
}
