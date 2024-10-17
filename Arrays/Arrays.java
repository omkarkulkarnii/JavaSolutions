public class Arrays {

    public static int[] moveZeros(int[] arr){
        // 1,2,0,3,0,0,5
        // 1,2,3,5,0,0,0
        int j = 0;
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) continue;
            else{
                ans[j] = arr[i];
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] arggs){
    int[] arr = {1,2,0,3,0,0,5};
    int[] some =  moveZeros(arr);
    for(int i = 0; i< some.length; i++){
        System.out.print(some[i] + " ");
    }
    }
}
