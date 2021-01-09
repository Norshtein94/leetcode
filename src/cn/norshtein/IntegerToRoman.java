package cn.norshtein;

/**
 *  <a href="https://leetcode-cn.com/problems/integer-to-roman/"> 12. 整数转罗马数字</a>
 */
public class IntegerToRoman {
    public static void main(String[] args){
        final String result = intToRoman(1994);
        System.out.println(result);
    }

    public static String intToRoman(int num) {
        String[] arr = new String[]{"I", "V", "X", "L", "C", "D", "M"};
        StringBuilder sb = new StringBuilder();
        int factor = 10;
        int n = num;
        int base = 0;
        // int b = 0;
        while (n > 0){
            // b = n % factor;
            switch (n % factor){
                case 0: break;
                case 1:
                    sb.append(arr[base]);
                    break;
                case 2:
                    sb.append(arr[base]);
                    sb.append(arr[base]);
                    break;
                case 3:
                    sb.append(arr[base]);
                    sb.append(arr[base]);
                    sb.append(arr[base]);
                    break;
                case 4:
                    sb.append(arr[base+1]);
                    sb.append(arr[base]);
                    break;
                case 5:
                    sb.append(arr[base+1]);
                    break;
                case 6:
                    sb.append(arr[base]);
                    sb.append(arr[base+1]);
                    break;
                case 7:
                    sb.append(arr[base]);
                    sb.append(arr[base]);
                    sb.append(arr[base+1]);
                    break;
                case 8:
                    sb.append(arr[base]);
                    sb.append(arr[base]);
                    sb.append(arr[base]);
                    sb.append(arr[base+1]);
                    break;
                case 9:
                    sb.append(arr[base+2]);
                    sb.append(arr[base]);
                    break;
            }
            n = n / factor;
            base += 2;
        }
        return sb.reverse().toString();
    }
}