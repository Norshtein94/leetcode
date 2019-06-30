package cn.norshtein;

/**
 * Created by Norshtein on 2019/6/30.
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args){
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArr = new int[nums1.length + nums2.length];
        int postion1 = 0, postion2 = 0, position = 0;
        while (postion1 < nums1.length && postion2 < nums2.length){
            if (nums1[postion1] <= nums2[postion2]){
                mergeArr[position++] = nums1[postion1++];
            }else{
                mergeArr[position++] = nums2[postion2++];
            }
        }
        while (postion1 < nums1.length){
            mergeArr[position++] = nums1[postion1++];
        }
        while (postion2 < nums2.length){
            mergeArr[position++] = nums2[postion2++];
        }
        double median = 0;
        if (mergeArr.length%2 == 1){
            median = mergeArr[mergeArr.length / 2];
        }else {
            median = (double)(mergeArr[mergeArr.length / 2] + mergeArr[(mergeArr.length / 2)-1]) / 2;

        }
        return median;
    }
}
