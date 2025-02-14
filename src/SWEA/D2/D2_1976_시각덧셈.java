package SWEA.D2;
import java.util.Scanner;

public class D2_1976_시각덧셈 {
	    static int T;
	    static int time=0;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        T = sc.nextInt();
	         
	        for (int t = 1; t <= T; t++) {
	            time = 0;
	            for (int i = 0; i < 4; i++) {
	                if(i%2 == 0)
	                    time += sc.nextInt()*60;	/*시간을 분으로 고치고 더한다.*/
	                else
	                    time += sc.nextInt();		/*분을 더한다*/
	            }
	            int h, m;
	            if(time/60%12==0) 					/*시간을 60으로 나누고 12로 나눈 나머지를 구한다.
								  						12가 기준이므로 0이 나오면 h에 12를 넣음	*/
	                h = 12;
	            else   
	                h = time/60%12;					/*나머지 1~11은 그래도 넣음*/
	             
	            m = time%60;						/*타임의 60으로 나눈 나머지는 분이기 때문에 넣어줌 */
	            System.out.println("#"+t+" "+ h+" "+m);
	        }
	    }
	}