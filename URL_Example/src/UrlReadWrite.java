import java.net.*;
import java.io.*;

public class UrlReadWrite {

	public static void main(String[] args) throws Exception {
		URL oracle = new URL("https://en.wikipedia.org/wiki/Tangent");
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));
		PrintWriter fout = new PrintWriter(new BufferedOutputStream(
				new FileOutputStream(
						"C:\\Users\\Lakshmipriya\\Desktop\\sample.html")));

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			String[] words = inputLine.split("\\s+");
			String newString = "";
			String find = "Tangent";
			String replacementString = "";
			for (String word : words) {
				if (!word.contains("<Title>") && !word.contains("<title>")) {
					if (word.contains(find)) {
						replacementString = "<mark>" + find + "</mark> ";
						newString += word.replaceAll(find, replacementString);
						continue;
					} else if (word.contains(find.toLowerCase())) {
						replacementString = "<mark> tangent </mark> ";
						newString += word.replaceAll(find.toLowerCase(),
								replacementString);
						continue;
					} else {
						replacementString = word + " ";
					}
				} else {
					replacementString = word + " ";
				}
				newString+=replacementString;
			}

			fout.write(newString);
		}
		in.close();
		fout.close();
	}
}
