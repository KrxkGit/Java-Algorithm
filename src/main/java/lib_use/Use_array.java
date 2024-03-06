package lib_use;

public class Use_array {
    public Use_array() {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.println(arr[i]);
        }
        System.out.println("result");
        for (int i: arr) {
            System.out.println(i);
        }
    }
}
