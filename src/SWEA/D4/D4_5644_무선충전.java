package SWEA.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D4_5644_무선충전 {
	static class BatteryCharger{
		int x,y,c,p;
		public BatteryCharger(int x, int y, int c, int p) {
			this.x = x; 	this.y = y;
			this.c = c;		this.p = p;
		}
		@Override
		public String toString() {
			return "BatteryCharger [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + "]";
		}
	}
	static int M, A;//이동횟수, BC개수 
	static int dr[] = {0,-1,0,1,0}, dc[]  = {0,0,1,0,-1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken()); //이동횟수
		A = Integer.parseInt(st.nextToken()); //BC개수
		
		//A의 이동 경로
		st = new StringTokenizer(br.readLine()," ");
		int [] aP = new int [M];
		int x=0;
		while(st.hasMoreTokens()) aP[x++] = Integer.parseInt(st.nextToken());

		//B의 이동 경로
		st = new StringTokenizer(br.readLine()," ");
		int [] bP = new int [M];
		x=0;
		while(st.hasMoreTokens()) bP[x++] = Integer.parseInt(st.nextToken());
		
		//BC 정보 입력
		List<BatteryCharger> BC = new ArrayList<>(); 
		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine()," ");
			BC.add(new BatteryCharger(
					Integer.parseInt(st.nextToken())-1, 
					Integer.parseInt(st.nextToken())-1, 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())));
		}
		
		go(aP,bP, BC); //a,b의 시작점 = 0,0 / 9,9
	}
	private static void go(int[] a, int [] b, List<BatteryCharger> BC) {
		
		int [] ad = new int[M+1]; 
		int [] bd = new int[M+1]; 
		
		//1. a사람 최초 지점이 BC에 포함되는지 확인
			for (int i = 0; i < A; i++) {
				if(distance(0,0, BC.get(i))) {
					ad[0] = Math.max(BC.get(i).p, ad[0]);
				}
			}
		//2. b사람 최초 지점이  BC에 포함되는지 확인
			for (int i = 0; i < A; i++) {
				if(distance(0,0, BC.get(i))) {
					bd[0] = Math.max(BC.get(i).p, bd[0]);
				}
			}
		//3. 사람을 이동시키고 BC에 포함이면 충전값을 구함
		int ax=0, ay=0, bx=9, by=9;
		for (int i = 1; i < M; i++) {
			int j = 0;
			List<Integer> alist = new ArrayList<Integer>();
			List<Integer> blist = new ArrayList<Integer>();
			
			for (int k = 0; k < A; k++) {
				if(distance(ax+=dr[a[j]], ay+=dc[a[j]], BC.get(k))) {
					alist.add(k);
				}
				if(distance(bx+=dr[b[j]], by+=dc[b[j]], BC.get(k))) {
					blist.add(k);
				}
				System.out.println(alist);
				System.out.println(blist);
				
				//조합
				ncr(0,0,2, alist, blist);
			}
		}	
	}
	private static void ncr(int cnt, int start, int r, List<Integer> alist, List<Integer> blist) {
		if(cnt==r) {
			
			return;
		}
	}
	private static boolean distance(int x, int y, BatteryCharger BC) {
		if(Math.abs(x-BC.x) + Math.abs(y-BC.y)<=BC.c) return true; //포함 ok
		return false;
	}
	
}
