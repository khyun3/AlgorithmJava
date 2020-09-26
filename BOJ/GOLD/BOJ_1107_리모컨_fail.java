package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨_fail {
	static int M; //이동할 채널, 고장난 버튼 수
	static boolean [] rmc = new boolean[10];
	static char [] N;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		N = br.readLine().toCharArray();
		M = Integer.parseInt(br.readLine());
		
		//초기 채널 번호
		int initNumber = 100;
		for (int i = 0; i < N.length; i++) {
			sb2.append(N[i]+"");
		}
		//들어온 번호가 100일 때
		if(initNumber==Integer.parseInt(sb2.toString())) {
			System.out.println(0);
			return;
		}
		//초기 채널과 차이를 본다.
		int gap =Math.abs(initNumber-Integer.parseInt(sb2.toString()));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//고장난 버튼 체크
		for (int i = 0; i < M; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			rmc[cnt] = true;
		}
		
		int [] closeNumber = new int[N.length];
		//N의 각각의 자리마다 가장 가까운 누를 수 있는 번호를 구한다.
		for (int i = 0; i < N.length; i++) {
			
			int number = Integer.parseInt(N[i]+"");//해당 자리의 수
			int selecter = Integer.MAX_VALUE;	//골라진 번호
			for (int j = 0; j < 10; j++) {
				
				//만약 누를 수 있다면
				if(!rmc[j]) {
					//가장 가까운 번호를 구한다
					if(Math.abs(number-j)<selecter) {
						selecter = Math.abs(number-j); 
						closeNumber[i] = j;
					}
				}
			}			 
		}
		sb2 = new StringBuilder();
		for (int i = 0; i < closeNumber.length; i++) {
			sb1.append(closeNumber[i]);
			sb2.append(N[i]+"");
		}
		int answer = Math.abs(Integer.parseInt(sb2.toString())-Integer.parseInt(sb1.toString()))+closeNumber.length;
		
		if(gap > answer)
			System.out.println(answer);
		else
			System.out.println(gap);
	}
}
