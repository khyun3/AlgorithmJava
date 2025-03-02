package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4134_다음소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {// O(N)
            long inputNumber = Long.parseLong(br.readLine());
            sb.append(findNextPrime(inputNumber)).append("\n");
        }
        System.out.println(sb);
    }
    //3
    static long findNextPrime(long inputNum) {//O(log M)
        boolean isPrime = false;
        while (!isPrime) {
            //4
            isPrime = checkPrime(inputNum);
            inputNum++;
        }
        //5
        return inputNum - 1;
    }

    static boolean checkPrime(long inputNum) {
        int sqrtInputNum = (int) Math.sqrt(inputNum);
        if (inputNum == 2 || inputNum == 3) {
            return true;
        }
        if(inputNum < 2 || inputNum % 2 == 0 || inputNum % 3 == 0){
            return false;
        }
        for (int i = 5; i <= sqrtInputNum; i+=2) { //O(√M)
            if (inputNum % i == 0) {
                return false;
            }
        }
        return true;

    }
}
