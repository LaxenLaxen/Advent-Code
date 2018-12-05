import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Vector;

public class Day5 {


	static Vector<String> listO = new Vector<String>();
	static String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Sebastian\\Desktop\\polymer.txt"); 

		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),Charset.forName("UTF-8")));

		int c;
		while((c = reader.read()) != -1) {
			char Ctemp = (char) c;
			String Stemp = Character.toString(Ctemp); 
			listO.add(Stemp);
		}

		//System.out.println(list);



		String best = "";
		int old = 10000000;
		for(int p = 0; p < Alphabet.length(); p++) {
			Vector<String> list = new Vector<String>();
			for(int q = 0; q < listO.size(); q++) {
				String temp = listO.get(q);
				if(temp.equals(Alphabet.substring(p, p+1)) || temp.equals(Alphabet.substring(p, p+1).toLowerCase())) {
					//System.out.println(Alphabet.substring(p, p+1));
				}
				else {
					list.add(temp);
				}
			}

			//System.out.println(list);
			Boolean run = true;
			int k = 0;
			while(run) {
				Boolean keepGoing = false;
				for(int i = k; i < list.size()-1; i++) {
					if(list.get(i).equals(list.get(i+1))) {
					}
					else if(list.get(i).equals(list.get(i+1).toLowerCase()) || list.get(i).equals(list.get(i+1).toUpperCase())) {
						keepGoing = true;
						//i = list.size();
						list.remove(i);
						list.remove(i);
						if(i > 0) {
							k = i - 1;
						}
						i = list.size();


					}
				}
				run = keepGoing;
			}
			if(list.size() < old) {
				old = list.size();
				best = Alphabet.substring(p, p+1);
			}
			//System.out.println(list);
		}

		System.out.println("Size: " + old + "  Char: " + best);
		//System.out.println(listO);
		//System.out.println(list);



	}

}

