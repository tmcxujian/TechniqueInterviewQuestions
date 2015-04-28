package LeetCode;
/**
 * 
 * @author xujian
 * Compare Version Numbers
 */
public class LeetCode_165 {
	
	public static int compareVersion2(String version1, String version2){
		String[] v1;
		String[] v2;
		//这个split函数非常精髓,正规表达式
		v1 = version1.split("\\.");
		v2 = version2.split("\\.");
		int x = 0;
		int y = 0;
		int size = v1.length > v2.length ? v2.length : v1.length;
		int i = 0;
		//比较前面共有的部分
		while(i < size){
			x = Integer.parseInt(v1[i]);
			y = Integer.parseInt(v2[i]);
			if(x < y){
				return -1;
			}
			else if(x > y){
				return 1;
			}
			i++;
		}
		//比较两个多出来的部分，但必须确认多出来的不是0
		if(v1.length > v2.length){
			for(int j = i; j < v1.length; j++){
				x = Integer.parseInt(v1[j]);
				if(x != 0){
					return 1;
				}
			}
		}
		else {
			for(int j = i; j < v2.length; j++){
				x = Integer.parseInt(v2[i]);
				if(x != 0){
					return -1;
				}
			}
		}
		return 0;
	}
	

	public static int compareVersion(String version1, String version2) {
		int i = 0;
		int j = 0;
		StringBuilder v1 = new StringBuilder();
		StringBuilder v2 = new StringBuilder();
		//单独比较
		while(i < version1.length() && j < version2.length()){
			while(i < version1.length() && version1.charAt(i) != '.'){
				v1.append(version1.charAt(i));
				i++;
			}
			while(j < version2.length() && version2.charAt(j) != '.'){
				v2.append(version2.charAt(j));
				j++;
			}
			if(Integer.parseInt(v1.toString()) == Integer.parseInt(v2.toString())){
				i++;
				j++;
				v1 = new StringBuilder();
				v2 = new StringBuilder();
				continue;
			}
			else {
				return (Integer.parseInt(v1.toString()) > Integer.parseInt(v2.toString()))
						? 1 : -1;
			}
		}
		//抛去多出来的0.比较大小
		while(i < version1.length() && ((version1.charAt(i) == '0') 
				|| (version1.charAt(i) == '.'))){
			i++;
		}
		while(j < version2.length() && ((version2.charAt(j) == '0') 
				|| (version2.charAt(j) == '.'))){
			j++;
		}
		if(i >= version1.length() && j < version2.length()){
			return -1;
		}
		else if(i < version1.length() && j >= version2.length()){
			return 1;
		}
		else{
			return 0;
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "0";
		String B = "1";
		System.out.println(compareVersion2(A, B));
	}

}
