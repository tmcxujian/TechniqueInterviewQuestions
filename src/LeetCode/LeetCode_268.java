package LeetCode;
//Linear time and could use extra constant space
//Use two numbers to keep track of upper and lower bound
public class LeetCode_268 {
	public static int missingNumber(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] + 1 < nums[i+1]){
            		return nums[i] + 1;
            }
        }
        return nums.length == 1 && nums[nums.length-1] != 0 ? 0: nums[nums.length-1]+1;
    }
	
	public static void main(String[] args){
		int[] nums = {1,0};
		System.out.println(missingNumber(nums));
	}
}
