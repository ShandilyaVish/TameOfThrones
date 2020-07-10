package raceCars;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
	public List<List<String>> data(File file) {
		List<List<String>> list = new ArrayList<List<String>>();
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String skip = br.readLine();
			while((line  = br.readLine()) != null) {
				String[] temp = line.split(",");
				list.add(Arrays.asList(temp));
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
