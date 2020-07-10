package raceCars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parts {
	static int fundUsed;
	public static int getTopSpeedOfGivenCar(List<List<String>> result,List<List<String>> parts,String partId,int fund,int baseSpeed,int topSpeed) {
		List<List<String>> changedList = new ArrayList<List<String>>();
		for(List<String> curr : parts) {
			if(curr.get(0).equals(partId)) {
				changedList.add(new ArrayList<String>(curr));
			}
		}
		int n = changedList.size() - 1;
		int total = knapsack(result,parts,new HashMap<>(),n,topSpeed - baseSpeed,fund);
		return total;
	}
	private static int knapsack(List<List<String>> result, List<List<String>> parts, Map<String,Integer> map, int n, int diff,
			int fund) {
		//if(fund < 0) return Integer.MIN_VALUE;
		if(n < 0 || fund == 0) return 0;
		String key = n + "|" + fund;
		if(!map.containsKey(key)) {
			int boost = Integer.valueOf(parts.get(n).get(3));
			int amt = Integer.valueOf(parts.get(n).get(2));
			int include = 0;
			if(diff - boost >= 0 && fund - amt >= 0) {
				include = boost + knapsack(result, parts, map, n-1, diff - boost, fund - amt);
			}
			int exclude = knapsack(result, parts, map, n - 1, diff, fund);
			if(include > exclude) {
				result.add(new ArrayList<>(parts.get(n)));
				map.put(key,include);
			}
			else {
				map.put(key,exclude);
			}
		}
		return map.get(key);
	}
	public static int getFundInt() {
		return fundUsed;
	}
}


//|part_list_id|part_id|price|speed_boost|
