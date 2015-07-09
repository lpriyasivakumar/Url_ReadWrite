import java.net.*;
import java.io.*;

public class UrlReadWrite {

	public static void main(String[] args) throws Exception {
		URL oracle = new URL("http://www.oracle.com/");
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));
		PrintWriter fout =  new PrintWriter(new BufferedOutputStream(new FileOutputStream("C:\\Users\\Lakshmipriya\\Desktop\\sample.html")));
	    	
		String inputLine;
		while ((inputLine = in.readLine()) != null){
			String[] words = inputLine.split("\\s+");
			String newString = "";
			for(String word: words){
				if(word.equalsIgnoreCase("the"))
					newString+= "<FONT style=\"BACKGROUND-COLOR: yellow\"> the </FONT>"+" ";
				else newString +=word+" ";
			}
			
			fout.write(newString);
		}
			
		in.close();
		fout.close();	        
	        
	}
}
