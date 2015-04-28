package LeetCode;
/**
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * @author xujian
 * Decode ways
 */
public class LeetCode_91 {

	public static int numDecodings(String s) {
		int len = s.length();
	    char[] nums = s.toCharArray();
	    if (len == 0 || nums[0] == '0') return 0;
	    int[] ways = new int[len];
	    ways[0] = 1;

	    for (int i=1; i<len; i++) {
	        // Add result calculated step back
	        ways[i] = ways[i-1];

	        // "00", "30"..."90" are not accepted
	        if (nums[i] == '0' && (nums[i-1] < '1' || nums[i-1] > '2')) return 0;

	        // Add result calculated two steps back
	        // if "11"..."19" or "21...26" but not like "110" or "210"
	        if (nums[i-1] == '1' && nums[i] != '0' && ((i+1 < len && nums[i+1] != '0') || i+1 == len)) {
	            ways[i] += i-2 > 0 ? ways[i-2] : 1;
	        }
	        if (nums[i-1] == '2' && nums[i] > '0' && nums[i] < '7') {
	            ways[i] += i-2 > 0 ? ways[i-2] : 1;
	        }
	    }
	    return ways[len-1];
    }
	
	public static void main(String[] args) {
		String s = "1212";
		System.out.println(numDecodings(s));
	}

}
