package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14888_연산자_끼워넣기_v1 {
    static int N, min = Integer.MAX_VALUE, max = -Integer.MAX_VALUE;
    static char[] inputOp;
    static int[] inputNum;
    static char[] selectedOperators;
    static boolean[] operatorUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inputNum = new int[N];
        selectedOperators = new char[N - 1];
        inputOp = new char[N - 1];
        operatorUsed = new boolean[N - 1];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            inputNum[i] = Integer.parseInt(str[i]);
        }

        String[] opCount = br.readLine().split(" ");
        int beforeIndex = 0;
        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(opCount[i]);
            for (int j = beforeIndex; j < beforeIndex + cnt; j++) {
                if (i == 0) inputOp[j] = '+';
                else if (i == 1) inputOp[j] = '-';
                else if (i == 2) inputOp[j] = '*';
                else inputOp[j] = '/';
            }
            beforeIndex += cnt;
        }

        //selected가 다 찾을 때 동일한 연산자는 선택되지 않도록!
        nPr(0);
        System.out.println(max + "\n" + min);
    }

    // 연산자 조합을 만들고 계산하는 함수
    static void nPr(int index) {
        if (index == N - 1) {
            int result = calc();
            min = Math.min(result, min);
            max = Math.max(result, max);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!operatorUsed[i] && selectedOperators[i] != inputOp[i]) {
                selectedOperators[index] = inputOp[i];
                operatorUsed[i] = true;
                nPr(index + 1);
                selectedOperators[index] = '.';
                operatorUsed[i] = false;
            }
        }
    }

    // 선택된 연산자 배열을 기반으로 결과를 계산하는 함수
    static int calc() {
        int result = inputNum[0];
        for (int i = 1; i < N; i++) {
            if (selectedOperators[i - 1] == '+') result += inputNum[i];
            else if (selectedOperators[i - 1] == '-') result -= inputNum[i];
            else if (selectedOperators[i - 1] == '*') result *= inputNum[i];
            else if (selectedOperators[i - 1] == '/') result = divide(result, inputNum[i]);
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
