import java.io.*;
import java.util.Vector;

public class Day1 {

	static Vector<Integer> frequancy = new Vector<Integer>();
	static Boolean running = true;
	static int total = 0;

	public static void main(String[] args) throws IOException {

		while(running == true) {
			getDuplicate();
		}

	}

	public static void getDuplicate() throws NumberFormatException, IOException {
		System.out.println("get");
		File file = new File("C:\\Users\\Sebastian\\Desktop\\fr.txt"); 

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st; 

		while ((st = br.readLine()) != null)  {
			//System.out.println(st); 
			if(st.charAt(0) == '+') {
				total += Integer.parseInt(st.substring(1));
			}
			else if(st.charAt(0) == '-' ) {
				total -= Integer.parseInt(st.substring(1));
			}

			if (frequancy.contains(total)) {
				System.out.println(st.substring(1));
				System.out.println(total);
				running = false;
				return;
			}

			frequancy.add(total);
			//System.out.println(total);
		} 
		br.close();

	}

}
