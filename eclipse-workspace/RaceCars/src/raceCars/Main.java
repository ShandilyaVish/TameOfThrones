package raceCars;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		String path1 = "C:\\Users\\vishr\\Downloads\\Data\\Teams.csv";
		String path2 = "C:\\Users\\vishr\\Downloads\\Data\\Cars.csv";
		String path3 = "C:\\Users\\vishr\\Downloads\\Data\\Parts.csv";
			
		List<List<String>> teams = new ArrayList<>();
		List<List<String>> cars = new ArrayList<>();
		List<List<String>> parts = new ArrayList<>();
		
		File file1 = new File(path1);
		File file2 = new File(path2);
		File file3 = new File(path3);
		
		try {
			CSVReader reader = new CSVReader();
			teams = reader.data(file1);
			cars = reader.data(file2);
			parts  = reader.data(file3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		FindTheFastest fastest = new FindTheFastest();
		int fast = fastest.compareFunction(teams, cars, parts);
		System.out.println(fastest.get() + "\n" + fast + "\n" + fastest.getInt() + "\n" + "Congratas");
		for(List<String> str : fastest.getPartList()) {
			System.out.println(str);
		}
		//System.out.println("Hi");
	}

}
