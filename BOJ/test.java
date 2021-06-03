import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class test {
	public static void main(String[] args) {
	
		File file = new File("test.txt");
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (int i = 1; i < 100001; i++) {
				writer.write(i+"\n");
			}
			writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}