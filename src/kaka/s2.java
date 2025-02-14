package kaka;

import java.util.ArrayList;
import java.util.Arrays;

public class s2 {
	public static void main(String[] args) {
		
		solution(new String[][] {
			{"POOOP", 
			 "OXXOX", 
			 "OPXPX", 
			 "OOXOX", 
			 "POXXP"}, 
			
			{"POOPX", 
			 "OXPXP", 
			 "PXXXO", 
			 "OXXXO", 
			 "OOOPP"},
			
			{"PXOPX", 
		     "OXOXP", 
		     "OXPXX", 
		     "OXXXP", 
		     "POOXX"}, 
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
	}
	static public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        
        for (int i = 0; i < places.length; i++) {
        	
        	//P 좌표 리스트 생성
            ArrayList<int []> list = new ArrayList<>();
            char [][] map = new char[5][5];
            
            for (int r = 0; r < 5; r++) {
            	map[r] = places[i][r].toCharArray();
    			for (int c = 0; c < 5; c++) {
    				if(map[r][c]=='P')
    					list.add(new int [] {r,c});
    			}
    		}
            
            int r1 = 0,r2 = 0,c1 = 0,c2 = 0;
            p:for (int a = 0; a < list.size(); a++) {
            	r1 = list.get(a)[0];
            	c1 = list.get(a)[1];
				
            	for (int b = a+1; b < list.size(); b++) {
					r2 = list.get(b)[0];
					c2 = list.get(b)[1];
					if(!distCheck(dist(r1,c1,r2,c2),r1,c1,r2,c2,map)) {
						answer[i] = 0;
						break p;
					}
				}
			}
		}
        return answer;
    }
	static int dist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
	static boolean distCheck(int distance, int r1, int c1, int r2, int c2, char [][] map) {
		switch(distance) {
		//거리가 1이면 파티션이 들어올 경우가 없음
		case 1:
			return false;

		//거리가 2일 때 파티션이 있는지 확인
		case 2:
			return partitionCheck(r1, c1, r2, c2, map);

		//거리가 3이상일 때는 앉아도 상관 없음
		default:
			return true;
		}
	}
	static boolean partitionCheck(int r1, int c1, int r2, int c2, char [][] map) {
		
		int dir[][] = new int [][] {{-1,0},{1,0},{0,-1},{0,1}}; 
		
		for (int i = 0; i < 4; i++) {
			int nr = r1+dir[i][0];
			int nc = c1+dir[i][1];
			
			if(!check(nr,nc)|| dist(nr,nc, r2, c2)>=2) continue;
			
			if(map[nr][nc]!='X') {
				return false;
			}
		}
		return true;
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nr<5 && nc>=0 && nc<5;
	}
}
