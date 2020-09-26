package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_경비원 {
	static int R, C, L;
	static int[] dist;
	static int [][] stores;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 가로와 세로길이
		C = Integer.parseInt(st.nextToken()); // 가로
		R = Integer.parseInt(st.nextToken()); // 세로
		
		// 상점의 개수
		int sn = Integer.parseInt(br.readLine());
		
		dist = new int[sn];
		
		stores = new int[sn+1][3]; // 상점 좌표 //마지막은 동근이 좌표
		
		// 1=북, 2=남,3=서,4=동
		for (int i = 0; i <= sn; i++) { //아놔;;; 동근이가 끝이지...?
			st = new StringTokenizer(br.readLine(), " ");
			switch (Integer.parseInt(st.nextToken())) {
			case 1://북 0,x
				stores[i][0] = 0;
				stores[i][1] = Integer.parseInt(st.nextToken());
				stores[i][2] = 1;
				break;
			case 2://남 r,x
				stores[i][0] = R;
				stores[i][1] = Integer.parseInt(st.nextToken());
				stores[i][2] = 2;
				break;
			case 3://서 x,0
				stores[i][0] = Integer.parseInt(st.nextToken());
				stores[i][1] = 0;
				stores[i][2] = 3;
				break;
			case 4://동 x,c
				stores[i][0] = Integer.parseInt(st.nextToken());
				stores[i][1] = C;
				stores[i][2] = 4;
				break;
			}
		}
		//동근이 좌푴ㅋㅋㅋ
		int dgr = stores[sn][0];
		int dgc = stores[sn][1];
		
		L=R*2+C*2;	
		
		for (int i = 0; i < sn; i++) {//하나의 상점과의 거리를 구하자
				boolean flag = true;
				int cnt = 0;
				int nr = stores[i][0];
				int nc = stores[i][1];
				
				while(flag) {//아무 방향이나 돌려봐 그리고 빼
					switch(stores[i][2]) {
					case 1://북쪽 0,x
						nc++;
						cnt++;
						if(nr==dgr && nc==dgc) {
							dist[i] = Math.min(L-cnt,cnt);
							flag =false;
							break;
						}
						if(nr==0 && nc==C) stores[i][2] = 4;//동쪽으로
						break;
						
					case 2://남 r,x
						nc--;
						cnt++;
						if(nr==dgr && nc==dgc) {
							dist[i] = Math.min(L-cnt,cnt);
							flag =false;
							break;
						}
						if(nr==R && nc==0) stores[i][2] = 3;//서쪽으로
						break;
						
					case 3://서 x,0
						nr--;
						cnt++;
						if(nr==dgr && nc==dgc) {
							dist[i] = Math.min(L-cnt,cnt);
							flag =false;
							break;
						}
						if(nr==0 && nc==0) stores[i][2] = 1;//서쪽으로
						break;
						
					case 4://동 x,c
						nr++;
						cnt++;
						if(nr==dgr && nc==dgc) {
							dist[i] = Math.min(L-cnt,cnt);
							flag =false;
							break;
						}
						if(nr==R && nc==C) stores[i][2] = 2;//남쪽으로
						break;
					}
				}
			}
		int answer=0;
		for (int j = 0; j < sn; j++) {
			answer += dist[j];
		}
		System.out.println(answer);
	}
}