import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Day3 {
	private static int size = 1000;
	static Integer[][] matrix = new Integer[size][size];
	static Vector<Integer> multiple = new Vector<Integer>();

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\Sebastian\\Desktop\\kord.txt"); 
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st;
		int nbr, left, up, width, height, counter = 0, temp = 0;
		while ((st = br.readLine()) != null)  {
			temp++;
			st = st.replace(" ", "");
			nbr = Integer.parseInt(st.substring(st.lastIndexOf('#')+1, st.lastIndexOf('@')));
			left = Integer.parseInt(st.substring(st.lastIndexOf('@')+1, st.lastIndexOf(',')));
			up = Integer.parseInt(st.substring(st.lastIndexOf(',')+1, st.lastIndexOf(':')));
			width = Integer.parseInt(st.substring(st.lastIndexOf(':')+1, st.lastIndexOf('x')));
			height = Integer.parseInt(st.substring(st.lastIndexOf('x')+1));
			//System.out.println(left + " " + up + " " + width + " " + height);
			multiple.add(width*height);
			for(int i = left; i < left+width; i++) {
				for(int k = up; k < up+height; k++) {
					if(matrix[i][k] == null) {
						matrix[i][k] = nbr;
					}
					else {
						matrix[i][k] = 0;
					}
				}
			}

		}
		/*day3_2
		for(int j = 0; j < temp; j++) {
			for(int i = 0; i < size; i++) {
				for(int k = 0; k < size; k++) {
					if(matrix[i][k] != null && matrix[i][k] == j+1) {
						counter++;
					}
				}
			}
			if(counter == multiple.get(j)) {
				System.out.println(j+1);
			}
			counter = 0;
		}*/

		/*day3_1
		for(int i = 0; i < size; i++) {
			for(int k = 0; k < size; k++) {
				if(matrix[i][k] != null && matrix[i][k] == 0) {
					counter++;
				}
			}
		}*/
		//System.out.print(counter);
	}

}
