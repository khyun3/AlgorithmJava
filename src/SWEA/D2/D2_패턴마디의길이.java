package SWEA.D2;
import java.util.Scanner;
class D2_패턴마디의길이{
    public static void main(String args[]) throws Exception
    {
        final int MAX_REPEAT_STR = 10;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String [] result = new String[T]; 
        
        for(int i=0; i<T; i++) {
            String input = sc.next();
           
            for(int j=0; j<MAX_REPEAT_STR; j++){
                if(input.substring(0, j+1).equals(input.substring(j+1, (j+1)*2))) {
                    result[i] = input.substring(0, j+1);
                    break;
                }
            }
        }
        for(int i=0; i<T; i++)
            System.out.println("#"+(i+1)+" "+result[i].length());
    }
}