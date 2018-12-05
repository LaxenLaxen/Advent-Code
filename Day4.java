import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public class Day4 {

	static Vector<Vector<String>> matrix = new Vector<Vector<String>>();
	static Vector<String> list = new Vector<String>();

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Sebastian\\Desktop\\testshift.txt"); 

		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 


		String st;
		int index = 0;
		while ((st = br.readLine()) != null)  {
			st = st.replace(" ", "");
			list.add(st);
		}
		Collections.sort(list);
		/*for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		Boolean inList = false;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).contains("#")) {
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
			if (inList == true) {
				matrix.get(index).add(list.get(i));
			}
			else if(!list.get(i).contains("#")) {
				matrix.lastElement().add(list.get(i));
			}
		}
		int ID = 0;
		int counterHigh = 0;
		int tempS = 0, tempA = 0;
		for(int i = 0; i < matrix.size(); i++) {
			int counterCurrent = 0;
			for(int k = 0; k < matrix.get(i).size(); k++) {
				if(matrix.get(i).get(k).contains("fallsasleep")) {
					tempS = Integer.parseInt(matrix.get(i).get(k).substring(11, 13)) * 60 + Integer.parseInt(matrix.get(i).get(k).substring(14, 16));					
				}
				if(matrix.get(i).get(k).contains("wakesup")) {
					tempA = Integer.parseInt(matrix.get(i).get(k).substring(11, 13)) * 60 + Integer.parseInt(matrix.get(i).get(k).substring(14, 16));
				}
				counterCurrent += tempA - tempS;
				//System.out.println(counterCurrent);
			}
			if(counterCurrent > counterHigh) {
				counterHigh = counterCurrent;
				index = i;
			}
			//System.out.println();
		}
		ID = Integer.parseInt(matrix.get(index).get(0).substring(matrix.get(index).get(0).indexOf('#')+1, matrix.get(index).get(0).indexOf('b')));
		System.out.println(ID);
		//System.out.println(counterHigh);

		Vector<Integer> a = new Vector<Integer>();
		for(int i = 0; i < matrix.get(index).size(); i++) {
			System.out.println(matrix.get(index).get(i));
			if(matrix.get(index).get(i).contains("fallsasleep")) {
				tempS = Integer.parseInt(matrix.get(index).get(i).substring(11, 13)) * 60 + Integer.parseInt(matrix.get(index).get(i).substring(14, 16));					
			}
			if(matrix.get(index).get(i).contains("wakesup")) {
				tempA = Integer.parseInt(matrix.get(index).get(i).substring(11, 13)) * 60 + Integer.parseInt(matrix.get(index).get(i).substring(14, 16));
				for(int k = tempS; k < tempA; k++) {
					a.add(k);
				}
			}
			
		}

		Collections.sort(a);
		a.add(0);
		int populare = 0;
		int temp1 = 1;
		int temp2 = 1;
		for(int i = 0; i < a.size()-1; i++) {
			if(a.get(i) == a.get(i+1)) {
				temp1++;
			}
			else if(a.get(i) != a.get(i+1)) {
				temp2 = temp1;
			}
			if(temp1 > temp2) {
				populare = a.get(i);
			}
		}
		System.out.println(populare);

		System.out.println(ID*populare);

	}

}
