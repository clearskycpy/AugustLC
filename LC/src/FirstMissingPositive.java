/**
 * @description:
 * @author：ClearSky
 * @date: 2023/8/11/011
 * @Copyright： https://clearskycpy.cn
 */
public class FirstMissingPositive {
    /**
     * 数字归位 {1,5,8,3,5,2,3} 9
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
//                dfs(nums[i],nums); 改成一个while
                int index =  nums[i];
                while (index <= nums.length && index > 0 && nums[index - 1] != index) {
                    int temp = nums[index - 1];
                    nums[index - 1] = index;
                    index = temp;
                }
            }
        }
//        for(int i : nums) System.out.print(i + " = ");
//        System.out.println();
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] != l + 1) return l + 1;
            if (nums[r] != r + 1) return r + 1;
            l++;
            r--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    /**
     * 将当前位置的数放下
     * @param index
     * @param nums
     */
    private void dfs(int index, int[] nums) {
        if (index > nums.length || index <= 0 || nums[index - 1] == index){
            return;
        }
        int temp = nums[index - 1];
        nums[index - 1] = index;
        dfs(temp,nums);
    }

    public static void main(String[] args) {
        int[] arr = {-1,6,4,3,2};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(arr));
    }
}
