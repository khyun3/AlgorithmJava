package SILVER;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_2961_도영이가만든맛있는음식 {
	static class Ingredients{
		long S;
		long B;
		public Ingredients(long s, long b) {
			super();
			S = s;
			B = b;
		}
		public Ingredients() {}
	}
	static int N; 
	static LinkedList<Ingredients> igd = new LinkedList<Ingredients>();
	static boolean [] isSelected;
	static int res=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		isSelected = new boolean[N];
		long S,B;	//10억 X 10억 하면 int형은 overflow
		
		for (int i = 0; i < N; i++) {
			S = sc.nextInt();
			B = sc.nextInt();
			if(N == 1) {	//N이 1이면 그냥 S-B 절대값 출력
				System.out.println(Math.abs(S-B));
				return;
			}//아니라면 igd객체에 add
			igd.add(new Ingredients(S,B));
		}
		subSet(0);	//부분집합 구하는 함수 호출
		System.out.println(res);
	}
	
	private static void subSet(int start) {
		int stmp=1, btmp=0;	//신맛 쓴맛 temp
		//기저
		if(start == N) {
			for (int i = 0; i < igd.size(); i++) {
				if(isSelected[i]) {
					stmp*=igd.get(i).S;	//신맛 곱하기
					btmp+=igd.get(i).B;	//쓴맛 더하기
				}
				if(btmp != 0 && res>Math.abs(stmp-btmp)) {	//btmp가 0이면 고른 재료가 1개도 없다는 소리(공집합)
					res = Math.abs(stmp-btmp);
				}
			}
			return;
		}
		//유도
		isSelected[start] = true;
		subSet(start+1);
		isSelected[start] = false;
		subSet(start+1);
	}
}