import java.util.Arrays;

public class Main {
        public int countPairs(int[] nums, int target) {  //-1,1,2,3,1  2
            (Arrays.sort(nums)); //-1,1,1,2,3
            int count = 0;
            for(int i : nums){
                if(i < target){ //count = 3
                    count++;
                    System.out.println(count);
                }else{
                    break;
                }
            }
            int ans = count * count - count / 2;
            System.out.println(ans);
            return ans;
        }

    public static void main(String[] args) {
     int[] arr= {-1,1,2,3,1};
     Main obj = new Main();
        System.out.println("answer from main method is "+obj.countPairs(arr, 2));
    }
}