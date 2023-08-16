/**
 * @description:
 * @author：ClearSky
 * @date: 2023/8/11/011
 * @Copyright： https://clearskycpy.cn
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                int i1 = mid, i2 = mid;
                while (i1 >= 0 && nums[i1] == target) {
                    i1--;
                }
                while (i2 < nums.length && nums[i2] == target) {
                    i2++;
                }
                return new int[] {i1 + 1, i2 - 1};
            }
            if (target >= nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
