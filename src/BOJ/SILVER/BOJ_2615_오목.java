package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {
	static int N = 19;
	static int [][] map = new int [N][N];
	static int [][] rc = new int[5][2];
	static int [] dr = {-1,-1,-1,0,0,1,1,1};
	static int [] dc = {-1,0,1,-1,1,-1,0,1};
	static int count = 1;
	static int [] answer = new int[3]; 
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		a:for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0) 
					answer = go(i,j, map[i][j]); //color =1 블랙, 2 흰
				if(answer[0] != 0) {
					System.out.println(answer[0]);
					System.out.println(answer[1]+1+" "+(answer[2]+1));
					flag = true;
					break a;
				}
			}
		}
		if(!flag) System.out.println(0);
	}

	private static int [] go(int r, int c, int color) {
		
		//8방검사 할꺼야
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!check(nr,nc)) continue;
			if(color != map[nr][nc]) continue;

			//우선 1개 더 검사했고~ 여기서 ++ 하면 2임 
				count++;
				int nrr = nr;
				int ncc = nc;
				//한방향으로 쭈욱 검사할꺼야
				while(true) {
					nrr +=dr[d]; 
					ncc +=dc[d];
					if(check(nrr,ncc) && color == map[nrr][ncc]) {
						count++;
						//System.out.println("count : "+ count+"  r : "+nrr+"  c : "+ncc);
					}
					else {
						break;	//같은 색아니거나 바둑판 넘기면
					}
				}
				//5갠가? 맞으면 가장 오른쪽이거나 가장 위쪽 좌표 
				if(count==5) {
					//만약에 5개가 맞았다? 그런데 반대 방향으로 같은 색 돌이 1개라도 더 있으면 GG
					if(check(r-dr[d], c-dc[d]) && color == map[r-dr[d]][c-dc[d]])
						return new int [] {0,0,0};
					else if(d == 5)
						return new int [] {color,r+4,c-4};
					else
						return new int [] {color,r,c};
				}
				//만약에 5개 아니면 카운트를 1로 초기화하고 끝내자
				else {count = 1;}	
		}
		return new int [] {0,0,0};
	}

	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}
}