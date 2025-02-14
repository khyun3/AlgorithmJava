package BOJ.SILVER;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_5568_카드놓기_nPr {
	
	static int N, R;		// R == k
	static int [] arr, numbers;
	static boolean [] isSelected;
	static String tmp="";
	static StringBuilder sb = new StringBuilder();
	static LinkedList<String> list = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		arr= new int[N];
		numbers= new int[R];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		nPr(N,R,0);	//nPr을 호출
		
		
		System.out.println(list.size());	//
	}
	
	static void nPr(int n, int r, int cnt) {
		//////////////////기저//////////////////////////
		if(cnt == r) {
			//선택된 친구들을 다 이어붙여서 문자열 생성 
			for (int i = 0; i < r; i++) {
				tmp += numbers[i];
			}
			//System.out.println("answer : "+tmp);
			
			if(!list.contains(tmp)) { 	//만약에 해당 문자열이 list에 포함 x 이면
				list.add(tmp);			//추가시킨다.
			}
			
			//System.out.println("answer : "+list.toString());
			tmp = "";
			return;
		}
		
		////////////////////유도//////////////////////////
		for (int i = 0; i < N; i++) {
			if(isSelected[i])continue;			
			numbers[cnt] = arr[i];		
			isSelected[i] = true;
			nPr(n,r,cnt+1);
			isSelected[i] = false;
		}
	}
}