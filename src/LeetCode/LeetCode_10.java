package LeetCode;

public class LeetCode_10 {
	//String.matches()可以包含regular expression
	public static boolean isMatch2(String s, String p){
		return s.matches(p);
	}
	
	//with recursive solutions
	public static boolean isMatch(String s, String p){
		if(p.length() == 0){
			return (s.length() == 0);
		}
		//因为*不可能出现在首位，之多只会出现在第二个位子
		if(p.length() == 1){
			return (s.length() == 1) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
		}
		//if '*' does not contain
		if(p.charAt(1) != '*'){
			if(s.length() < 1){
				return false;
			}
			else{
				return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && 
						isMatch(s.substring(1), p.substring(1));
			}
		}
		//else contains '*'
		//while loop里面是*前面的s和p字符串相同，那么一步步剖去相同的元素
		//while loop跳出去就说明*作用已经结束了，可以直接跳过*比较s和p后面部分了
		while(s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')){
			if(isMatch(s, p.substring(2))){
				return true;
			}
			s = s.substring(1);
		}
		return isMatch(s, p.substring(2));
	}
	
	//DP
	public static boolean isMatch3(String s, String p){
		int height = s.length(),width = p.length();
        boolean[][] dp = new boolean[height + 1][width + 1];
        dp[0][0] = true;
        for(int i = 1; i <= width; i++){
            if(p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
        }
        for(int i = 1; i <= height; i++){
            for(int j = 1; j <= width; j++){
                char sChar = s.charAt(i - 1);                
                char pChar = p.charAt(j - 1);
                if(sChar == pChar || pChar == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(pChar == '*'){
                    if(sChar != p.charAt(j - 2) && p.charAt(j - 2) != '.'){
                        dp[i][j] = dp[i][j - 2];
                    }else{
                        dp[i][j] =  dp[i][j - 2] | dp[i - 1][j];
                    }
                }
            }
        }
        return dp[height][width];
	}
	
	public static void main(String[] args) {
		 System.out.println(isMatch("aaa", "a.a") + " " + isMatch2("aaa", "a.a"));
		 System.out.println(isMatch("aa", "aa") + " " + isMatch2("aa", "aa"));
		 System.out.println(isMatch("aaa", "aa") + " " + isMatch2("aaa", "a"));
		 System.out.println(isMatch("aa", "a*") + " " + isMatch2("aa", "a*"));
		 System.out.println(isMatch("aa", ".*") + " " + isMatch2("aa", ".*"));
		 System.out.println(isMatch("ab", ".*") + " " + isMatch2("ab", ".*"));
		 System.out.println(isMatch("aab", "c*a*b") + " " + isMatch2("aab", "c*a*b"));
		
		 System.out.println(isMatch("", "") + " " + isMatch2("", ""));
		 System.out.println(isMatch("abcdeff", ".*") + " " + isMatch2("abcdeff", ".*"));
		 System.out.println(isMatch("a", "ab*") + " " + isMatch2("a", "ab*"));
		System.out.println(isMatch("bb", ".bab") + " " + isMatch2("bb", ".bab"));

	}
}
