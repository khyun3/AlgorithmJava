
public class test {
	public static void main(String[] args) {
		int [] input = new int [20];
		int [] sw = new int [5];
		int max = 0;
		
		recur(0, input, false);
	}

	private static void recur(int i, int[] input, boolean k) {
		System.out.println(input[i]);
		if(k || i==input.length-1) {
			k= true;
			recur(i-1, input, k);
			
		}
		recur(i+1, input, k);
	}
}
