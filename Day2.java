import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

	static int total2 = 0;
	static int total3 = 0;

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Sebastian\\Desktop\\id.txt"); 
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st;

		while ((st = br.readLine()) != null)  {
			System.out.println(st);
			count(st);

		}

		System.out.println("dubbletter: " + total2);
		System.out.println(" trippletter: " + total3);
		System.out.println(total2 * total3);

	}

	public static void count(String line) {
		int temp = 0;
		Boolean counter2 = false;
		Boolean counter3 = false;
		for(int i = 0; i < line.length(); i++) {
			char inString = line.charAt(i);
			for(int k = 0; k < line.length(); k++) {
				if(line.charAt(k) == inString) {
					temp++;
				}
			}
			if(temp == 2) {
				counter2 = true;
			}
			if(temp == 3) {
				counter3 = true;
			}
			temp = 0;
		}
		if(counter2) {
			total2++;
		}
		if(counter3) {
			total3++;
		}

	}

}
