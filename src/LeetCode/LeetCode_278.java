package LeetCode;
/**
 * First Bad Version
 * Suppose you have n versions [1, 2, ..., n] and 
 * you want to find out the first bad one, 
 * which causes all the following ones to be bad.
 * @author xjan
 * Binary Search
 */
public class LeetCode_278 {
	/*Here true means this particular version is bad while false means that is good*/
	private static boolean[] versionArray = {true,true,true,true,false,false,false};
	//private static boolean[] versionArray = {false,false};
	//private static boolean[] versionArray = {true,false};
	/*This is the API given to return whether version is bad*/
	public static boolean isBadVersion(int version){
		return versionArray[version-1];
	}

	public static int firstBadVersion(int n) { 
		int low = 1;
		int high = n;
        while(high >= low){
        		int midVersion = low + (high - low) / 2;
        		boolean temp = isBadVersion(midVersion);
        		System.out.println(temp + " " + midVersion);
        		if(temp){
        			high = midVersion - 1;
        		} else {
        			low = midVersion + 1;
        		}
        }
        return low;
    }
	
	public static void main(String[] args){
		System.out.println(firstBadVersion(versionArray.length));
	}
}
