package LeetCode;
/**
 * Single Number II
 * @author xujian
 *
 */
public class LeetCode_137 {
	public int singleNumber(int[] A) {
		int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
        		for (int j = 0; j < A.length; j++) {
        			if (((A[j] >> i) & 1) == 1) {
        				count[i]++;
        			}
        		}
        		result |= ((count[i] % 3) << i);
        }
        return result;
    }
}
