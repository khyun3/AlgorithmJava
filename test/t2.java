import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class t2 {
	
	public static void main(String[] args) throws Exception {
		String S =
				"715K 2009-09-23 system.zip~"
				+"\n179K 2013-08-14 to-do-list.xml~"
				+"\n645K 2013-06-19 blockbuster.mpeg~"
				+"\n 536 2010-12-12 notes.html"
				+"\n688M 1990-02-11 delete-this.zip~"
				+"\n 23K 1987-05-24 setup.png~"
				+"\n616M 1965-06-06 important.html"
				+"\n 14M 1992-05-31 crucial-module.java~"
				+"\n192K 1990-01-31 very-long-filename.dll~";
		
		int answer = 9999;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date standardDate = df.parse("1990-01-31");
		
		StringTokenizer fileTok = new StringTokenizer(S,"\n");
		StringTokenizer elTok = null;

		while(fileTok.hasMoreTokens()) {
			elTok = new StringTokenizer(fileTok.nextToken(),"");
			String size = elTok.nextToken();
			Date date = df.parse(elTok.nextToken().toString());
			String name = elTok.nextToken();
			String extension = null;
			boolean type = name.contains("~");
			name = type ? name.substring(0, name.length()-2) : name;
			System.out.println(name);
			StringTokenizer st = new StringTokenizer(name, ".");
			name = st.nextToken();
			extension = st.nextToken();
			
			//백업 파일 확인
			if(!type) continue;
			
			//크기 비교			
			if(size.contains("M")) {
				st = new StringTokenizer(size, "M");
				if(Integer.parseInt(st.nextToken())>14) continue;
			}
			else if(size.contains("G")) {
				continue;
			}
			//날짜 비교
			int compare = standardDate.compareTo(date);
			if(compare>0) continue;
			
			answer = Math.min(answer, name.length());
		}
	}
}
