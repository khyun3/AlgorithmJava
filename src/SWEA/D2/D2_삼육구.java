package SWEA.D2;
import java.util.Scanner;

public class D2_삼육구{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] div = new int[4];
        int checker = 0;
        String printChecker = "";
          
        for(int i=1; i<=n; i++) {    
              
            div[3] = i/1000;
            div[2] = i%1000/100;
            div[1] = i%100/10;
            div[0] = i%10;
              
            for(int j=0; j<4; j++) {
                if(div[j]!=0 && div[j]%3 == 0) {
                    checker++;
                    printChecker += "-";
                }
            }
            if(checker == 0)
                System.out.print(i+" ");
            else
                System.out.print(printChecker+" ");
              
            printChecker = "";
            checker = 0;
        }
    }
}