package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] twoSumMyCode(int[] nums, int target){
		//runtime: 54ms
		//Complexity : O(N^2)
		int [] result = new int[2];
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == target){
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}
	
	
	public static int[] twoSumMap(int[] nums, int target){
		//runtime : 12ms
		//Complexity: O(N) 
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++){
			if(map.containsKey(target - nums[i])){
				result[0] = map.get(target - nums[i]);
				result[1] = i;
			}
			map.put(nums[i], i);
		}
		return result;
	}
	
	public static int[] twoSumMap_2(int[] nums, int target){
		// runtime: 7ms
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){

            Integer diff = (Integer)(target - nums[i]);
            if(hash.containsKey(diff)){
                int toReturn[] = {hash.get(diff), i};
                return toReturn;
            }

            hash.put(nums[i], i);

        }
        
        return null;
		
	}
	
	public static int[] twoSum_n2(int[]nums, int target){
		// runtime: 6ms
		int[] nums2 = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums2);
		int a = 0, b = 0;
		int start = 0, end = nums.length - 1;
		while(start < end){
			int sum = nums2[start] + nums2[end];
			if(sum < target)
				start++;
			else if(sum > target)
				end --;
			else{
				a = nums2[start];
				b = nums2[end];
				break;
			}
		}
		int[] res = new int[2];
		for(int i=0; i<nums.length; i++){
			if(nums[i] == a){
				res[0] = i;
				break;
			}
		}
		if(a != b){
			for(int i =0; i<nums.length; i++){
				if(nums[i] == b){
					res[1] = i;
					break;
				}
			}
		}
		else{
			for(int i = 0; i<nums.length; i++){
				if(nums[i] == b && i != res[0]){
					res[1] = i;
					break;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		//int[] result = twoSumMyCode(nums, target);
		int[] result = twoSumMap(nums, target);
		//int[] result = twoSum_n2(nums, target);
		//int[] result = twoSumMap_2(nums, target);
		for (int i : result) {
			System.out.print(i + " ");
		}
		
	}
}
