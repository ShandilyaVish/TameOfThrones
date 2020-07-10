package raceCars;

import java.util.ArrayList;
import java.util.List;

public class FindTheFastest {
	String car_name = "";
	int fun;
	List<List<String>> returnList;
	public int compareFunction(List<List<String>> teams,List<List<String>> cars,List<List<String>> parts){
		//List<String> result;
		//List<String> temp = new ArrayList<>();
		int max = 0;
		for(List<String> list : teams) {
			String carId = list.get(2);
			int fund = Integer.parseInt(list.get(list.size()-1));
			int curr_car_topSpeed = Cars.getTopSpeed(carId,fund,cars,parts);
			if(max < curr_car_topSpeed) {
				max = curr_car_topSpeed;
				//temp = new ArrayList<>(curr_List);
				car_name = Cars.getString();
				fun = Cars.fundUsed();
				returnList = Cars.getList();
			}
		}
		return max;
	}
	public String get() {
		return car_name;
	}
	public int getInt() {
		return fun;
	}
	public List<List<String>> getPartList() {
		return returnList;
	}
}
