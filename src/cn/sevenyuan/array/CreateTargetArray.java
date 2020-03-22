package cn.sevenyuan.array;

/**
 * @author JingQ at 2020/3/22
 */
public class CreateTargetArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4};
        int[] index = new int[] {0,1,2,2,1};
        createTargetArray(nums, index);
    }


    private static int[] target = new int[101];


    public static int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int tempIndex = index[i];
            back(tempIndex, i);
            target[tempIndex] = nums[i];
            count++;
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = target[i];
        }
        return result;
    }

    private static void back( int start, int end) {
        if (end < start) {
            return;
        }
        for (int i = end; i >= start; i--) {
            target[i+1] = target[i];
        }
    }

}
