package cn.norshtein;

/**
 * <a href="https://leetcode-cn.com/problems/zigzag-conversion">6. Z 字形变换</a>
 */
class ZigzagConversion {
    public static void main(String[] args){
        final String result = convert("AB", 1);
        System.out.println(result);
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder result = new StringBuilder();
        int len = s.length();
        for (int n = 0; n < numRows; n++){
            boolean down = n != 0;
            for (int i = n; i < len; i += 2 * (down ? n : numRows-n-1)){
                result.append(s.charAt(i));
                if (n > 0 && n < numRows-1){
                    down = !down;
                }
            }
        }
        return result.toString();
    }
}