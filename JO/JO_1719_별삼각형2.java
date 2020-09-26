
import java.util.Scanner;

public class JO_1719_별삼각형2 {
	static int N, M; // 높이, 종류
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		if(N>100 || N%2 == 0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		M = sc.nextInt();
		switch (M) {
		case 1:
			printCase12();
			break;
		case 2:
			printCase12();
			break;
		case 3:
			printCase34();
			break;
		case 4:
			printCase34();
			break;
		default:
			System.out.println("INPUT ERROR!");
			break;
		}
	}

	static void printCase12() {
		for (int i = -N/2; i <= N/2; i++) {
			sb = new StringBuilder();				//한 줄 출력합니다~
			for (int j = 0; j <N/2+1; j++) {		//0~N/2+1까지 *또는 " " append 
				if(j<=Math.abs(Math.abs(i)-N/2))
					sb.append("*");
				else
					sb.append(" ");
			}
			if(M==1)								
				System.out.println(sb);				//case 1일 때,
			else 									 
				System.out.println(sb.reverse());	//case 2일 때, reverse
													//사실 append다 해서 한방에 출력할려고했는데
													//Presentation Error남(\n)까지 뒤집힘
		}
	}
	static void printCase34() {
		for (int i = -N / 2; i <= N / 2; i++) {
			sb = new StringBuilder();
			for (int j = -N / 2; j <= N / 2; j++) {
				if (Math.abs(j) <= Math.abs(i)) {	//양 끝에 1개, 총 2개가 줄어들다가 다시 늘어남 
					sb.append("*");
				} else
					sb.append(" ");
			}
			if(M==4) {								//case 4일 때
				if(i<=0)
					sb.replace(N/2+1, sb.length(), ""); //case 3결과를 replace
				else
					for (int j = 0; j < N/2; j++)	//replace가 범위지정이라 1칸씩..하고싶은..나에겐..
					sb.replace(j, j+1, " ");		//반복문 뿐이야...
				}
			System.out.println(sb);
		}
	}
}