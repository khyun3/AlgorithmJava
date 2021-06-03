package 모의역량테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
#1 9760
#2 72095
#3 118750 
#4 98645 v
#5 160635
#6 1202920 v
#7 279310 v
#8 3120311 v
#9 38565366 v
#10 15490100 v
 * */
public class Mock20210423_01 {
	static class Cell{
		int state; //각 셀의 상태
		int militaryPower; //군사력
		int supply; //셀에 보충되는 병력
		int tmp; //공격 시 해당 셀에서 빠질 병력의 수
		int sTmp;//보충 시 해당 셀에서 더해질 병력의 수
		int mTmp;//보충 시 해당 셀에서 빠질 병력의 수
		int stateTmp;
		int mpTmp;
		
		@Override
		public String toString() {
			return "[" + state + ", " + militaryPower +", " + supply +", "+ sTmp+", "+mTmp +"]";
		}
		public Cell(int state) {
			this.state = state;
			this.stateTmp = state;
		}
		public Cell() {}
		public void setMilitaryPower(int militaryPower) {
			this.militaryPower = militaryPower;
		}
		public void setSupply(int supply) {
			this.supply = supply;
		}
	}
	static int T,N, maxCountryNum, countryCnt[];
	static Cell[][] map;
	static int dir[][] = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new Cell[N][N];
			countryCnt = new int[4];
			maxCountryNum = 0;
			
			//각 지역의 소유 정보를 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					map[i][j] = new Cell(tmp);
					maxCountryNum = Math.max(maxCountryNum, tmp);
					countryCnt[tmp]++;
				}
			}
			
			//각 지역의 병력 정보를 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j].setMilitaryPower(Integer.parseInt(st.nextToken()));
				}
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j].setSupply(Integer.parseInt(st.nextToken()));
				}
			}
			int result = play();
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static int play() {
		
		int turn = 1;
		while(true) {
			//모든 지역 통일 확인
			if(unityCheck()) {
				return count();
			}
			if(countryCnt[turn]>0) {
				System.out.println("현재 턴은 "+turn+"나라");
				//공격
				attack(turn);
				
				//지원
				support(turn);
				
				//보충
				supplement();
			}
			
			if(maxCountryNum!=0) {
				switch(turn) {
				case 1:
					turn = 2;
					break;
				case 2:
					turn = 3;
					break;
				case 3:
					turn = 1;
					break;
				}
			}
		}
	}
	static void attack(int turn) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Cell cell = map[i][j];

				//현재 턴 나라의 땅이 아니면
				if(cell.state!= 0 && cell.state!=turn) {
					int total = 0;
					//상하좌우로 인접한 자신의 나라의 병력의 합을 구한다.
					for (int d = 0; d < 4; d++) {
						int nr = i + dir[d][0];
						int nc = j + dir[d][1];
						
						//맵의 범위안에 있고 현재 턴인 나라와 state가 같지 않다면 continue
						if(!check(nr,nc) || map[nr][nc].state!=turn) continue;
						
						total+=map[nr][nc].militaryPower;
					}
					//자신의 나라의 병력의 합이 5 배를 초과할 경우, 각 지역에서 1/4 의 병력을 보내 공격한다.
					if(total > (cell.militaryPower*5)) {
						int mp = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i + dir[d][0];
							int nc = j + dir[d][1];
							
							if(!check(nr,nc) || map[nr][nc].state!=turn) continue;
							
							//각 지역에서 1/4의 병력을 보낸다.
							int p = map[nr][nc].militaryPower/4;
							mp += p;
							map[nr][nc].tmp += p;
						}
						countryCnt[cell.state]--;
						cell.stateTmp = turn;
						//공격 받는 애
						cell.mpTmp += mp;
//						System.out.println("("+i+", "+j+") = "+cell.mpTmp);
					}
				}
			}
		}
		setTmp(1);
		System.out.println("공격 끝나고 나서");
		print();
	}
	static void setTmp(int flag) {
		if(flag == 1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j].mpTmp!=0) {
						map[i][j].militaryPower = map[i][j].mpTmp - map[i][j].militaryPower;
					}
					map[i][j].state = map[i][j].stateTmp;
					map[i][j].militaryPower -= map[i][j].tmp;
					map[i][j].tmp = 0;
					map[i][j].mpTmp = 0;
				}
			}
		}
		else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j].militaryPower -= map[i][j].mTmp;
					map[i][j].militaryPower += map[i][j].sTmp;
					map[i][j].sTmp = 0;
					map[i][j].mTmp = 0;
				}
			}
		}
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
	static void support(int turn) {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				Cell cell = map[i][j];
				
				if(cell.state!=turn) continue;
				
				for (int d = 0; d < 4; d++) {
					int nr = i +dir[d][0];
					int nc = j +dir[d][1];
					
					if(!check(nr,nc) || map[nr][nc].state==turn || map[nr][nc].state==0) {
						cnt++;
						continue;
					}
				}
				//1. 인접한 지역 중 다른 나라의 지역이 없는 경우, 모든 인접한 지역으로 그 지역의 병력의 1/5을 각각 지원한다.
				if(cnt==4) {
					int tmp = cell.militaryPower/5;
					int mvCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i +dir[d][0];
						int nc = j +dir[d][1];
						if(!check(nr,nc) || map[nr][nc].state==0) continue;
						
						map[nr][nc].sTmp += tmp;
						mvCnt++;
					}
					cell.mTmp += tmp*mvCnt;
					System.out.println("인접 없음  r="+ i+"  c="+ j +" 보내는 병력 : "+ tmp);
					print();
				}
				//2. 인접한 지역 중 다른 나라의 지역이 있을 경우, 
				//   그 지역의 병력이 인접한 아군 나라의 병력의 5 배를 초과할 경우에만, 그 지역의 병력의 1/5을 인접한 지역으로 지원한다				
				else if(cnt<4 && cnt>0){
					int tmp = cell.militaryPower/5;
					int mvCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i +dir[d][0];
						int nc = j +dir[d][1];
						if(!check(nr,nc) || map[nr][nc].state==0 || map[nr][nc].state!=turn) continue;
						
						if(map[nr][nc].militaryPower*5 < cell.militaryPower) {
							map[nr][nc].sTmp += tmp;
							mvCnt++;
						}
					}
					cell.mTmp +=tmp*mvCnt;
					System.out.println("인접 있음    r="+ i+"  c="+ j +" 보내는 병력 : "+ tmp);
					print();
				}
			}
		}
		setTmp(2);
	}
	static void supplement() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j].militaryPower += map[i][j].supply;
			}
		}
//		print();
	}
	
	static boolean unityCheck() {
		int k = -1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int state = map[i][j].state;
				//막약 state가 0이 아니고
				if(state != 0) {
					
					//k가 -1이 아니고 state가 만약 이전 cell과 같다면 지속
					if(k!=-1 && k == state) continue;

					//만약 0이 아닌 칸을 처음 만난다면
					else if(k==-1) {
						k = state;
					}
					
					//만약 0이 아닌 칸을 처음 만나지도 않고 이전 cell과 같은 국가가 아니라면
					else {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	static int count() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += map[i][j].militaryPower;
			}
		}
		return result;
	} 
	
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j].toString()+" ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
}
