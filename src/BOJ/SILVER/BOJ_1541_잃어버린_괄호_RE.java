package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1541_잃어버린_괄호_RE {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 숫자와 연산자를 분리한다.
        String[] input = br.readLine().split("(?<=[+-])|(?=[+-])");

        List<Integer> nums = new ArrayList<>();
        //2. 빼기가 나오기 전까지 정수형으로 바꾸어 더해둔다.
        int sum = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i++) {
            switch (input[i - 1]) { // 이전값을 확인한다.
                case "+": //+면 현재값을 sum에 더한다.
                    sum += Integer.parseInt(input[i]);
                    break;
                case "-": //-면 현재 sum을 nums에 넣고 sum을 현재값으로 초기화한다.
                    nums.add(sum);
                    sum = Integer.parseInt(input[i]);
                    break;
                default:
                    break;
            }
        }
        //마지막 sum을 nums에 넣는다.
        nums.add(sum);

        //첫 수부터 모두 빼서 정답을 구한다.
        int answer = nums.getFirst();
        for (int i = 1; i < nums.size(); i++) {
            answer -= nums.get(i);
        }

        System.out.println(answer);
    }
}
