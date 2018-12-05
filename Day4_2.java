import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public class Day4_2 {

	static Vector<Vector<String>> matrix = new Vector<Vector<String>>();
	static Vector<String> list = new Vector<String>();

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Sebastian\\Desktop\\shift.txt"); 

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String st;
		int index = 0;
		while ((st = br.readLine()) != null)  {
			st = st.replace(" ", "");
			list.add(st);
		}

		Collections.sort(list);
		Boolean inList = false;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).contains("#") && !list.get(i+1).contains("#")) {
				for(int k = 0; k < matrix.size(); k++) {
					inList = false;
					for(int j = 0; j < matrix.get(k).size(); j++) {
						if(matrix.get(k).get(j).contains(list.get(i).substring(17))) {
							inList = true;
							index = k;
							break;
						}
					}
					if(inList == true) {
						break;
					}
				}
				if (inList == false) {
					Vector<String> temp = new Vector<>();
					temp.add(list.get(i));
					matrix.add(temp);
				}
			}
			else if(list.get(i).contains("#") && list.get(i+1).contains("#")) {

			}
			else {
				if (inList == true) {
					matrix.get(index).add(list.get(i));
				}
				else if(!list.get(i).contains("#")) {
					matrix.lastElement().add(list.get(i));
				}
			}
		}

		//System.out.println(matrix);

		int counterHigh = 0;
		int tempS = 0, tempA = 0;
		for(int i = 0; i < matrix.size(); i++) {
			System.out.println(matrix.get(i));
			//System.out.println(i);
			int counterCurrent = 0;
			for(int k = 0; k < matrix.get(i).size(); k++) {
				if(matrix.get(i).get(k).contains("fallsasleep")) {
					tempS = Integer.parseInt(matrix.get(i).get(k).substring(14, 16));					
				}
				else if(matrix.get(i).get(k).contains("wakesup")) {
					tempA = Integer.parseInt(matrix.get(i).get(k).substring(14, 16));
					counterCurrent = counterCurrent + (tempA - tempS);
				}

				//System.out.println(counterCurrent);
			}
			if(counterCurrent > counterHigh) {
				counterHigh = counterCurrent;
				index = i;
			}
			//System.out.println();
		}


		int ID = 0;
		//ID = Integer.parseInt(matrix.get(index).get(0).substring(matrix.get(index).get(0).indexOf('#')+1, matrix.get(index).get(0).indexOf('b')));

		//System.out.println(counterHigh);

		Vector<Vector<Integer>> matrixSleep = new Vector<Vector<Integer>>();
		for(int k = 0; k < matrix.size(); k++) {
			Vector<Integer> temp = new Vector<>();

			Boolean test = false;
			for(int i = 0; i < matrix.get(k).size(); i++) {
				//System.out.println(matrix.get(index).get(i));
				if(matrix.get(k).get(i).contains("fallsasleep")) {
					tempS = Integer.parseInt(matrix.get(k).get(i).substring(14, 16));					
				}
				if(matrix.get(k).get(i).contains("wakesup")) {
					tempA = Integer.parseInt(matrix.get(k).get(i).substring(14, 16));
					for(int j = tempS; j < tempA; j++) {
						temp.add(j);
					}
					test = true;
				}
			}
			if(test == true) {
				test = false;
				Collections.sort(temp);
				temp.add(0);
				matrixSleep.add(temp);
			}
		}


		int populare = 0;
		int temp1 = 1;
		int temp2 = 1;
		for(int k = 0; k < matrixSleep.size(); k++) {
			System.out.println(matrixSleep.get(k));
			temp1 = 1;
			for(int i = 0; i < matrixSleep.get(k).size()-1; i++) {
				if(matrixSleep.get(k).get(i) == matrixSleep.get(k).get(i+1)) {
					temp1++;
				}
				else if(matrixSleep.get(k).get(i) != matrixSleep.get(k).get(i+1)) {
					temp1 = 1;
				}
				if(temp1 > temp2) {
					temp2 = temp1;
					populare = matrixSleep.get(k).get(i);
					ID = Integer.parseInt(matrix.get(k).get(0).substring(matrix.get(k).get(0).indexOf('#')+1, matrix.get(k).get(0).indexOf('b')));
				}
			}
		}
		System.out.println("ID: " + ID);
		System.out.println("Most number of hits: " + temp2);
		System.out.println("Minute that occured most: " + populare);

		System.out.println("Answer: " + populare * ID);

	}

}