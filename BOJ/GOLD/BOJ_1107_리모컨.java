package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	static String N;
	static boolean btn[], flag;
	static int pBtn[], selected[], answer[], K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		btn = new boolean[10];	//버튼
		N = br.readLine();		//이동해야할 채널
		int cnt = Integer.parseInt(br.readLine());
		

		getBrokenButton(cnt, br);	//고장난 버튼을 입력받음
		getNotBrokenButton(cnt);	//고장나지 않은 버튼의 배열을 만듬
		
		//최초 채널은 100번이고 +나 -버튼만으로 이동하는 경우 횟수를 구함
		answer = new int [N.length()+1];
		Arrays.fill(answer, Math.abs(Integer.parseInt(N) - 100));
		K = Math.abs(Integer.parseInt(N));
		
		//이제 최소 횟수로 버튼을 눌러서 N에 도달하는 방법을 구함
		for (int r = 1; r <= N.length()+1; r++) {
//			flag = false;
			selected = new int [r]; 
			getMinCnt(0, r, r-1);
		}
		printAnswer();
	}
	static void printAnswer() {
		int ans = 500001;
		for (int i : answer) {
			ans = Math.min(i, ans);
		}
		System.out.println(ans);
	}
	static void getMinCnt(int cnt, int r, int index) {
//		if(flag) return;
		if(cnt == r) {
			StringBuilder sb = new StringBuilder();
			
			//하나의 스트링으로 만들기
			for (int i = 0; i < r; i++) {
				sb.append(selected[i]);
			}
			//눌러야 하는 횟수
//			System.out.print(K + " - " + Integer.parseInt(sb.toString())+" + "+r+"\t");
			int res = Math.abs(K - Integer.parseInt(sb.toString()))+r;
			answer[index] = Math.min(answer[index], res);
//			System.out.println(Arrays.toString(selected)+"   ans : "+ answer[index]);
			return;
		}
		
		for (int i = 0; i < pBtn.length; i++) {
			selected[cnt] = pBtn[i];
			getMinCnt(cnt+1, r, index);
		}
	}
	static void getNotBrokenButton(int cnt) {
		int index = 0;
		pBtn = new int[10-cnt];
		for (int i = 0; i < 10; i++) {
			if(!btn[i]) {
				pBtn[index++] = i;
			}
		}
	}
	static void getBrokenButton(int cnt, BufferedReader br)throws Exception {
		if(cnt!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < cnt; i++) {
				int k = Integer.parseInt(st.nextToken());
				btn[k] = true;
			}
		}
	}
}