import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Arrays;

public class MatheMatics {
    public static BigInteger factorial(BigInteger a){
    if(a.equals(BigInteger.ZERO) || a.equals(BigInteger.ONE)){
        return BigInteger.ONE;
    }
    else{
        return a.multiply(factorial(a.subtract(BigInteger.ONE)));
    }
    }
    public static String oddEven(int[] a){
        String ans = "";
        for(int i = 0; i< a.length; i++){
            if(a[i] %2 == 0){
                ans += "Even";
            }
            else{
                ans += "Odd";
            }
        }
        return ans;
    }
    public static int PermutationsWithVowelsFixed(String a){
        int count = 0;
        char[] arr = a.toCharArray();
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == 'a' ||arr[i] == 'e' ||arr[i] == 'i' ||arr[i] == 'o' ||arr[i] == 'u' ){
                count++;
            }

        }
        int remaining = arr.length - count;
        return smallFactorialHelper(remaining);
    }
    public static int smallFactorialHelper(int n){
        if(n == 1 ||  n == 0){
            return 1;
        }
        else{
            return n * smallFactorialHelper(n - 1);
        }
    }
    public static int additionOfEven(int[] arr){
        int ans = arr[0];
        for(int i  = 1; i< arr.length; i++){
            if(i % 2 == 0) {
                ans = ans + arr[i];
            }
        }
        return ans;
    }
    public static int additionOfEvenReversed(int[] arr){
        reverseIntArray(arr);
        int ans = arr[0];
        for(int i  = 1; i< arr.length; i++){
            if(i % 2 == 0) {
                ans = ans + arr[i];
            }
        }
        return ans;
    }
    public static int[] reverseIntArray(int[] arr){
        int i = 0;
        int j = arr.length -1;
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
    public static void printFloydsAlgo(int n){
        /*
        n = 6
        1
        2 3
        4 5 6
        7 8 9 10
        11 12 13 14 15
        16 17 18 19 20 21
         */
        System.out.println("Floyds Triangle pattern for "+ n+ " rows :\n"+
                "******************");
        int startwith = 1;
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(startwith + " ");
                startwith++;
            }
            System.out.println();
        }
        System.out.println("Floyds Triangle pattern end \n" +
                "******************");
    }
    public static int sumOfN(int n){
        return n * ((n + 1)/2);
    }
    public static void printInReverse(int n){
        for(int i = n; i >=1; i--){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void printInReverseEvenSkipped(int n){
        for(int i = n; i >=1; i--){
            if(i % 2 == 0){
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static int sumOfNInGivenRange(int start, int end){
        int ans  = 0;
        for(int i = start; i <= end ; i++ ){
            ans  = ans + i;
        }
        return ans;
    }
    public static boolean LeapOrNot(int yr){


        return (yr%4) == 0 ;
    }
    public static int AddAllDigits(long n){
        int ans = 0;
        while(n != 0){
            ans += n % 10;
            n = n / 10;
        }
        return ans;
    }
    public static boolean[] isPalisArms(int n){
        boolean pal = false;
        boolean arms = false;
        int og = n;
        int rev = 0;
        ArrayList<Integer> lg = new ArrayList<>();
        while(n > 0){
            int lastdg = n % 10;
            lg.add(lastdg);
            rev = (rev*10) + lastdg;
            n = n /10;
        }
        if(rev == og)
            pal = true;
        int sumForArms = 0;
        for(int i : lg){
            sumForArms = sumForArms + ( i * i * i);
        }
        if(sumForArms == og)
            arms = true;

        boolean[] answers = new boolean[]{pal, arms};
        return answers;
    }
    public static int[] reverseNumber(int m){
        //1234

    int ans = 0;
    int count = 0;
    while(m > 0){
        int  lastdigit= m%10; //4
        m = m/10;
        ans =(ans*10) + lastdigit ; // 0 * 10 + 4 = 4
        count++;
    }
    int[] answers = new int[]{ans, count};
    return answers;
}
    public static boolean isPrime(int n){
        //n=12;
        boolean ans = false;
        int count = 0;
        for(int i = 1; i*i <= n;){      //  y, y, y,
            if((n % i) == 0){           //  y, y, n,
                count++;                //  c1, c3
                if((n/i) != i ){        //  12/1 = 12 y, 12/2 = 6 y
                    count++;            //  c2, c4
                }                       //
            }
            i++;                        // 1..,2..,3..,4
        }
        if(count == 2) ans = true;
        return ans;
    }
    public static int gcd(int a, int b){
        while(a > 0 && b > 0){
            if(a > b) a= a % b ;
            if( b > a) b = b % a;
        }
        if(a == 0) return b;
        return a;
    }
    public static int fiboOfN(int n){
        if(n == 0 || n == 1) return n;
        int a = 0 ;
        int b = 1;
        int c  = 0;
        for(int i = 2; i<= n ; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static String decToBin(int n){

        return Integer.toBinaryString(n);

    }
    public static String decToBinHardCoded( int n ){
        if(n == 0 ) return "0";
        if( n == 1) return "1";
        String ans = "";
        while(n > 0){
            if( (n & 1)==1)  ans = "1" + ans;
            if( (n&1)== 0) ans = "0" + ans;
           n = n >> 1;
        }
        return ans;
    }
    public static String ZeroAndOnes(String bin) {
        //bin 11101101
        String ans = "";
        char[] arr = bin.toCharArray();
        int count = 0;
        for (char a : arr) {
            if (a == '1') {
                count++;
            }
            if (a == '0') {
               ans= ans+ alphabetDig(count);
               count = 0;
            }
        }
    if(count > 0) ans = ans+ alphabetDig(count);
    return ans;
    }
    public static char alphabetDig(int a){

        return (char) ('A' +  a -1);

    }
    public static boolean isGooglyPrime(int num){
        int sum = 0;
        while(num > 0){
            sum = sum +( num % 10 );
            num = num / 10;
        }
        return isPrime(sum);
    }

    public static void main(String args[]){

        //Mathematcis and cp foundation once in and all

        System.out.println("total set bit counts is"+ Integer.bitCount(42));
        String a = Integer.toBinaryString(42);
        System.out.println("the binar no of " + 42 + " is "+ a );
        int number = 10;  // Example
        BigInteger result = factorial(BigInteger.valueOf(number));
        System.out.println("prime factor of " + number+" is "+ result);
        while(result.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
            result = result.divide(BigInteger.TEN);
        }
        //here result gets destroyed
        System.out.println("the non zero ending of the result is"+result.mod(BigInteger.TEN));
        System.out.println("Print if odd or even "+oddEven(new int[]{2,3,4,5,1,5,6,}));
        System.out.println("permutation of fixed vowels "+ PermutationsWithVowelsFixed("aezqw"));
        System.out.println("addition of even postition elems " + additionOfEven(new int[]{1,2,3,4,5,6})); //9
        int[] arr= new int[]{1,2,3,4,5};
        reverseIntArray(arr);
        System.out.print("reversed array :" );
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
        System.out.println("addititon of reversed even position elems" + additionOfEvenReversed(new int[]{1,2,3,4,5,6}) );
        printFloydsAlgo(6);
        System.out.println(sumOfN(5));
        printInReverse(10);
        printInReverseEvenSkipped(12);
        System.out.println("sum Of N In Given Range"+sumOfNInGivenRange(5, 5));
        System.out.println("is the year leap yr or not "+LeapOrNot(2004));
        System.out.println("sum of digits of given number is "+ AddAllDigits(1230456));
        System.out.println("reversed number is "+reverseNumber(12345)[0] + " and the count of digits is " +reverseNumber(12345)[1] );
        System.out.println("is the number palindrome? : " + isPalisArms(12321)[0] + " and is the number armstrong number? : " + isPalisArms(371)[1] );
        System.out.println("is 1313 prime? " +isPrime(1313));
        System.out.println("gcd using euclidean's algorithm is " + gcd(12,7));
        System.out.println("fibonacci seires of nth numer is : " + fiboOfN(9));
        System.out.println("binary form of n is : " + decToBin(54));
        System.out.println("binary form of n in hard coded is  : " + decToBinHardCoded(54));
        System.out.println("digit number of alphabet is : " + alphabetDig(8));
        System.out.println("digit number of alphabet is : " + ZeroAndOnes("1101011111111"));
        System.out.println("is the sum off digits a prime number" +isGooglyPrime(43));

    }
}
