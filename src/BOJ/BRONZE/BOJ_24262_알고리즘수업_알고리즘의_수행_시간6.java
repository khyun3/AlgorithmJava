package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제
오늘도 서준이는 알고리즘의 수행시간 수업 조교를 하고 있다.
아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
입력의 크기 n이 주어지면 MenOfPassion 알고리즘 수행 시간을 예제 출력과 같은 방식으로 출력해보자.
MenOfPassion 알고리즘은 다음과 같다.

```
MenOfPassion(A[], n) {
    sum <- 0;
    for i <- 1 to n - 2
        for j <- i + 1 to n - 1
            for k <- j + 1 to n
                sum <- sum + A[i] × A[j] × A[k]; # 코드1
    return sum;
}
```

입력
첫째 줄에 입력의 크기 n(1 ≤ n ≤ 500,000)이 주어진다.

출력
첫째 줄에 코드1 의 수행 횟수를 출력한다.
둘째 줄에 코드1의 수행 횟수를 다항식으로 나타내었을 때, 최고차항의 차수를 출력한다.
단, 다항식으로 나타낼 수 없거나 최고차항의 차수가 3보다 크면 4를 출력한다.
*/
public class BOJ_24262_알고리즘수업_알고리즘의_수행_시간6 {
    public static void main(String[] args) throws IOException {
        // loop 1 : 1       -> n - 2
        // loop 2 : i + 1   -> n - i - 1
        // loop 3 : j + 1   -> n - j
        // i=1, j=2, k=3,4,5
        // i=1, j=3, k=4,5
        // i=1, j=4, k=5
        // i=2, j=3, k=4,5
        // i=2, j=4, k=5
        //...
        // i=3,4,5
        BufferedReader br = new   BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        //n개중 중복없이 3개를 고르는 조합과 수행 횟수가 동일함
        //따라서 수행 횟수는 nC3
        System.out.println((n*(n-1)*(n-2))/6);
        //menOfPassion을 다항식으로 나타내면 f(n) = n^3 따라서 최고차항의 차수는 3
        System.out.println(3);
    }
}
