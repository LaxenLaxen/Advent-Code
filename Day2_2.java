import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Day2_2 {

	static Vector<String> list = new Vector<String>();

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Sebastian\\Desktop\\id.txt"); 
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st;

		while ((st = br.readLine()) != null)  {
			list.add(st);
		}
		for(int k = 0; k < list.get(1).length(); k++) {
			compare(k);
		}
	}

	public static void compare(int k) {
		Vector<String> templist = new Vector<String>();
		String newString;
		for(int i = 0; i < list.size(); i++) {
			newString = list.get(i).substring(0, k) + list.get(i).substring(k+1);
			if(templist.contains(newString)) {
				System.out.println(newString);
			}
			templist.add(newString);
		}
	}
}
