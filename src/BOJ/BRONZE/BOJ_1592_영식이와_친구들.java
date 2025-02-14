package BOJ.BRONZE;

// day0817;

import java.util.Scanner;

public class BOJ_1592_영식이와_친구들 {
	static int N,M,L, answer=0;
	static int [] people;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 3 <= N <= 1000	//인원 수
		M = sc.nextInt(); // M <= 1000		//공을 받는 횟수(게임 종료 조건)
		L = sc.nextInt(); // L <= N-1		//시계, 반시계방향으로 L번째
		people = new int[N];
		int check = 0;
		int ball = 0;
		people[ball] = 1;	//1번이 공을 가진다.
		//System.out.println(Arrays.toString(people));

		while(check!=M) {
			if(people[ball]%2 != 0) { //홀수이면 시계 ->
				ball=(ball+L)%N;	//볼을 받은 사람 갱신
				check = ++people[ball];
			}
			else {	//짝수이면 반시계 <-
				ball= ball-L;	//볼을 받은 사람 갱신
				if(ball<0) {
					ball=(N+ball)%N;
				}else {
					ball=(ball)%N;
				}
				check = ++people[ball];
			}
			answer++;
			//System.out.println(Arrays.toString(people));
		}
		System.out.println(answer);
	}
}
