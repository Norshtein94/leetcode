package cn.norshtein;

import java.util.Arrays;

/**
 *  <a href="https://leetcode-cn.com/problems/3sum-closest/"> 16. 最接近的三数之和</a>
 */
public class ThreeSumCloset {

    public static void main(String[] args){
        final int result = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(result);
    }

    /**
     * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 示例：
     *
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int p0 = 0, p1 = 1, p2 = len-1;
        int minDiffValue = nums[0]+nums[1]+nums[2];
        int minDiff = Math.abs(target - minDiffValue);
        for (p0 = 0; p0 < len; p0++){
            for (p1 = p0+1,p2=len-1; p2 > p1 && p2 < len; ){
                int value = nums[p0] + nums[p1] + nums[p2];
                final int diff = Math.abs(target - value);
                if (diff == 0){
                    return value;
                }
                if (minDiff > diff){
                    minDiff = diff;
                    minDiffValue = value;
                }
                if (target < value){
                    p2--;
                }else {
                    p1++;
                }
            }
        }
        return minDiffValue;
    }
}