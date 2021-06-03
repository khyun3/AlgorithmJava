import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class p3 {
	public static void main(String[] args) {
		
		solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
		solution(8, 2, new String[] {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
		solution(5,4, new String[] {"C"});
	}
	
	static char [] ansCharArr;
	static public String solution(int n, int k, String[] cmd) {
        ansCharArr = new char[n];
        Arrays.fill(ansCharArr, 'O');
        Stack<Integer> stk = new Stack<>();
        //표의 행을 선택, 삭제, 복구
        //단, 한 번에 한 행만 선택
        
//        System.out.println(k);
        for (int i = 0; i < cmd.length; i++) {
        	int x = 0;
        	StringTokenizer st = new StringTokenizer(cmd[i]);
			switch(st.nextToken()) {
			
			//"U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
			case "U":
				x = Integer.parseInt(st.nextToken());
				if(ansCharArr[k]!='O') k--;
				k=up(x, k-1);
//				System.out.println(x+"칸 위로 -> \t"+ k);
				break;
			
			//"D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
			case "D":
				x = Integer.parseInt(st.nextToken());
				k = down(x, k+1);
//				System.out.println(x+"칸 아래로 -> \t"+ k);
				break;
			
			//"C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 
			//      단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
			case "C":
				ansCharArr[k]='X';
				stk.push(k);
				boolean check = false;
//				int check = Arrays.binarySearch(ansCharArr, k+1, ansCharArr.length, 'O');
				for (int j = k+1; j < ansCharArr.length; j++) {
					if(ansCharArr[j]=='O') {
						check = true;
						break;
					}
				}
				if(!check || k==n-1) {
					//바로 윗행을 선택
					k = up(1,k-1);
				}
				else {
					//바로 아래 행 선택
					k = down(1,k+1);
				}
//				System.out.println(" 선택된 행 : "+k);
				break;
			
			//"Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
			case "Z":
				int recover = stk.pop();
				ansCharArr[recover] = 'O';
				break;
			}
		}
        StringBuilder sb = new StringBuilder();
        for (char c : ansCharArr) {
			sb.append(c);
		}
        System.out.println(sb.toString());
        return sb.toString();
    }
	static int up(int x, int k) {
		int check = k;
		System.out.println(k);
		while(x-->0) {
			check = Arrays.binarySearch(ansCharArr, 0, check, 'O');
			System.out.println("up"+check);
		}
		for (int i = k; i >= 0; i--) {
			switch(ansCharArr[i]) {
			case 'O':
				if(--x==0) {
					System.out.println("최종 up k = "+i);
					return i;
				}
			}
		}
		
		return k+1;
	}
	static int down(int x, int k) {
		int check = k;
		while(x>0) {
			check = Arrays.binarySearch(ansCharArr, check, ansCharArr.length, 'O');
			x--;
			System.out.println("do"+check);
		}
		
		
		for (int i = k; i < ansCharArr.length; i++) {
			switch(ansCharArr[i]) {
			case 'O':
				if(--x==0) {
					System.out.println("최종 do k = "+i);
					return i;
				}
			}
		}
		
		return k-1;
	}
}
