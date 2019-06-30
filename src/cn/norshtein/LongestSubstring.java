package cn.norshtein;

/**
 * Created by Norshtein on 2019/6/30.
 */
public class LongestSubstring {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * leetcode最优解
     * @param s
     * @return
     */
    public int best(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] set = new int[128];
        for (int i = 0; i < set.length; i++)
            set[i] = -1;

        char[] cs = s.toCharArray();
        int start = 0, max = 0;
        for (int i = 0; i < cs.length; i++){
            if (set[cs[i]] >= start)
                start = set[cs[i]] + 1;
            max = Math.max(max, i-start+1);
            set[cs[i]] = i;
        }
        return max;
    }


    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int firstMatch = s.indexOf(c);
            if (firstMatch >= 0 && firstMatch < i){
                max = max > i ? max : i;
                if (max >= 26)
                    break;
                s = s.substring(firstMatch+1);
                i -= firstMatch+1;
            }else if (i == s.length()-1){
                max = max > i+1 ? max : i+1;
            }
        }
        return max;
    }
}
