package D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1288_새로운불면증치료법 {
	static int T, answer=1;
	static String N;
	static boolean [] checked; //0~9
	static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		T = sc.nextInt();
	
		//N은 kN으로 증가함
		for (int t = 1; t <=T; t++) {
			N = sc.next();
			checked = new boolean[10];
			
			int kN = Integer.parseInt(N);

			do {
				StringBuilder kNstr= new StringBuilder();	//새로운 kN의 길이
				kNstr.append(kN);
				
				char [] num= new char [kNstr.length()];
				
				num = kNstr.toString().toCharArray();
				
				for (int i = 0; i < num.length; i++) {
					checked[num[i]-'0'] = true;  
					//System.out.println(Arrays.toString(checked));
				}
				for (int i = 0; i < checked.length; i++) {
					flag = true; //가정 : 모든 숫자가 나왔다. 참
					
					if(!checked[i]) { //가정 :거짓
						flag = false;
						break;
					}
				}
				kN = kN+Integer.parseInt(N);
				//System.out.println(kN);
			}
			while(!flag);
			System.out.println("#"+t+" "+(kN-Integer.parseInt(N)));
		}
	}
}