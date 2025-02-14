package BOJ.SILVER;
import java.util.Scanner;

public class BOJ_2527_직사각형 {
	
	static int x1,x2,y1,y2,  a1,a2,b1,b2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			
			x1 = sc.nextInt(); y1 = sc.nextInt();
			x2 = sc.nextInt(); y2 = sc.nextInt();
			
			a1 = sc.nextInt(); b1 = sc.nextInt();
			a2 = sc.nextInt(); b2 = sc.nextInt();
			
			System.out.println(sol());
		}
	}
	
	static char sol() {
		if(x1 > a2 || x2 < a1 || b1>y2 || b2<y1) {
			return 'd';
		}
		else if((x1==a2&&y1==b2)||(x1==a2&&y2==b1)||(x2==a1&&y2==b1)||(x2==a1&&y1==b2)) {
			return 'c';
		}
		else if((x1==a2&&y2>b1)||(x1==a2&&y1<b2)||(x2==a1&&y2>b1)||(x2==a1&&y1<b2)||(y1==b2&&x1<a2)||(y1==b2&&x2>a1)||(y2==b1&&x1<a2)||(y2==b1&&x2>a1)) {
			return 'b';
		}
		else {
			return 'a';
		}
	}
}