package raceCars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Cars {
	static String car_name;
	static int fundOverallUsed ;
	static List<List<String>> returnList;
	static int returnMax;
	public static int getTopSpeed(String carId,int funds,List<List<String>> cars,List<List<String>> parts){
		int baseSpeed = 0;
		int topSpeed = 0;
		String part_id = "";
		List<List<String>> result = new ArrayList<List<String>>();
		int max = 0;
		for (List<String> list : cars) {
			if(list.get(0).equalsIgnoreCase(carId)) {
				baseSpeed = Integer.valueOf(list.get(2));
				topSpeed = Integer.valueOf(list.get(3));
				part_id = list.get(list.size()-1);
			    max = Parts.getTopSpeedOfGivenCar(result, parts, part_id, funds, baseSpeed, topSpeed);
			    car_name = list.get(1);
				break;
			}
		}
		returnList = result;
		if(max == 0) returnMax = baseSpeed;
		else returnMax= max;
		return returnMax;	
	}
	public static String getString() {
		return car_name;
	}
	public static int fundUsed() {
		return fundOverallUsed;
	}
	public static List<List<String>> getList() {
		return returnList;
	}
}


//|car_id|car_name|base_speed|top_speed|part_list_id|