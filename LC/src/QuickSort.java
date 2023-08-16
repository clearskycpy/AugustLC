public class QuickSort {

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] arr = new int[] {1,34,5,7,8,45,675,3,2,9};
        q.quickSort(arr,0, arr.length - 1);
        for(int i : arr){
        System.out.println(i);
        }
    }
//    Implement a Quicksort
    public void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) return;
        int mid = sort(arr,begin,end);
        quickSort(arr,begin,mid - 1);
        quickSort(arr,mid + 1, end);
    }
    // 具体排序规则
    public int sort(int[] arr, int begin, int end) {
        int key = arr[begin]; // 中间值保存 避免被覆盖
        int left = begin;
        int right = end;
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right]; // 填坑
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        int m = left;
        arr[m] = key;
        return m;
    }

}
