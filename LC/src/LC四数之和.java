import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC四数之和 {
    List<List<Integer>> list;
    int[] arr;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        list = new ArrayList<>();
        arr = nums;
        LinkedList<Integer> temp = new LinkedList<>();
        dfs(temp,0,target,0);
        return list;
    }

    private void dfs(LinkedList<Integer> temp, int sum, int target, int index) {
        if (target == sum && temp.size() == 4) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (target > sum || index >= arr.length || temp.size() > 4) {
            return;
        }
        dfs(temp,sum,target,index + 1);   // 不加
        temp.addLast(arr[index]);
        sum += arr[index];
        dfs(temp,sum,target,index + 1);
        sum -= arr[index];
        temp.removeLast();

    }
}
