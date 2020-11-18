package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14981_톱니바퀴 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Character> t[] = new LinkedList[4]; 
		
		char [] in = new char [8];
		for (int i = 0; i < 4; i++) {
			in = br.readLine().toCharArray();		
			//바퀴 만들기
			t[i] = new LinkedList<>();
			for (int j = 0; j < 8; j++) {
				t[i].offer(in[j]);
			}
		}//바퀴 입력 끝
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		//바퀴 돌리기
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine()," ");
			move(t, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
		}
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			if(t[i].get(0)=='1') {
				if(i==0) ans+=1;
				else if(i==1) ans+=2;
				else if(i==2) ans+=4;
				else if(i==3) ans+=8;
			}
		}
		System.out.println(ans);
	}

	private static void move(LinkedList<Character> [] t, int roll, int d) {
		//앞 index 2 , 뒤 index 6
		int left = roll;
		int right = roll;
		//-1(반시계), 0(돌x), 1(시계) 로 상태 구분해서 돌리는거 아닌거 선택 
		int [] tr = new int [4]; 
		tr[roll] = d;
		for (int i = 0; i < 4; i++) {
			if(--left>=0) {
				//이전 바퀴가 회전할 때, 닿아 있는 부분이 다른가?
				if(t[left+1].get(6) == t[left].get(2)) tr[left] = 0;
				else tr[left] = -tr[left+1];
			}
			if(++right<=3) {
				if(t[right-1].get(2) == t[right].get(6)) tr[right] = 0;
				else tr[right] = -tr[right-1];
			}
		}
		for (int i = 0; i < 4; i++) {
			if(tr[i]==0) continue;
			else if(tr[i]==1) { //시계방향 회전
				t[i].addFirst(t[i].get(7));
				t[i].remove(8);
			}
			else {//반시계 방향 회전
				t[i].addLast(t[i].get(0));
				t[i].remove(0);
			}
		}
	}
}