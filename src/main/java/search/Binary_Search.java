package search;

import java.util.ArrayList;
import java.util.Arrays;

public class Binary_Search {
    public Binary_Search() {
        Integer[] a = {33,1,2,6,8,9,100,40};
        Arrays.sort(a);
        System.out.println(Search(a, 44));
        Help(a, 23);
    }

    private int count = 0;
    public void Help(Integer[] arr, Integer target) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(arr)); // 数组 转换为 arrayList
        int index = Arrays.binarySearch(arr, target);
        System.out.printf("%d ", index); // 库方法
    }
    public int Search(Integer[] arr, Integer target) {
        // 返回查询的次数
        if (target == arr[arr.length/2]){
            System.out.println(arr[arr.length/2]);
            return count;
        } else {
            if (arr.length/2 == 0) { // 折半后长度为0
                return -1; //不存在
            }
            count++;
            if (target < arr[arr.length/2]) {
                return Search(Arrays.copyOfRange(arr, 0, arr.length/2), target);
            } else {
                return Search(Arrays.copyOfRange(arr, arr.length/2, arr.length), target);
            }
        }

    }
}
