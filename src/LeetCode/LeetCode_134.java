package LeetCode;
/**
 * Gas Station
 * @author xujian
 *
 */
public class LeetCode_134 {
	
	//This one is brutal force. Go through each step and see if it could work out
	public static int canCompleteCircuitBrutalForce(int[] gas, int[] cost) {
		for(int i = 0; i < gas.length; i++){
			//i represents to be starting index
			int time = 1;
			int gasInToal = gas[i];
			int gasCost = cost[i];
			while(time < gas.length && gasInToal >= gasCost){
				gasInToal += gas[(i+time) % gas.length];
				gasCost += cost[(i+time) % cost.length];
				time++;
			}
			if(time == gas.length && gasInToal >= gasCost){
				return i;
			}
		}
        return -1;
    }
	
	//求{gas[]-cost[]}最大子段和 
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0;
		int sum = 0;
		int startIndex = -1;
		for(int i = 0; i < gas.length; i++){
			sum += (gas[i] - cost[i]);
			total += (gas[i] - cost[i]);
			if(sum < 0){
				startIndex = i;
				sum = 0;
			}
		}
		return total >= 0 ? startIndex + 1 : -1;
	}
	
	public static int canCompleteCircuit2(int[] gas, int[] cost) {
		int[] edge = new int[gas.length];
		int sum = 0;
		for(int i = 0; i < gas.length; i++){
			edge[i] = gas[i] - cost[i];
			sum += edge[i];
		}
		if(sum < 0){
			return -1;
		}
		int startIndex = maxSumCycle(edge, 0, 0);
		return startIndex;
	}
	
	//To be continued;
	public static int maxSumCycle(int[] edge, int start, int end){
		int sum = 0;
		int i = 0;
		int j = 0;
		while(start < edge.length){
			if(i == start){
				break;
			}
		}
		return 0;
	}
	
}
