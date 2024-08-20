import java.util.*;
//import java.util.HashSet;

public class StringProblems {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter string");
//        String s = sc.next();
//        sc.close();
        System.out.println(LongestSubstringWithoutRepeatingCharacters("abaabc"));
        System.out.println(isAnaHash("abaa","baq"));
        System.out.println(isAnagram("abaa","baq"));
        System.out.println(isPalindrome("abbaa"));
        Frequency("abaa");

    }
    public static void Frequency(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> mapper : map.entrySet()) {
            char key = mapper.getKey();
            int value = mapper.getValue();
            System.out.print(key + ": " + value + ", ");

        }
    }
    public static boolean isAnagram(String s1, String s2){
        //abaa //baaa
        int Char = 256;
        if(s1.length() != s2.length()) return false;
        int[] freq = new int[Char];
        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }
        for(int i = 0; i < Char; i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isAnaHash(String s1, String s2){
        HashMap< Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s1.length(); i++){
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) +1);
        }
       for(int i=0;i<s2.length();i++){
           char c = s2.charAt(i);
           if(map.containsKey(c) != true){
               return false;
           }
           map.put(c, map.get(c) -1);
           if(map.get(c) == 0){
               map.remove(c);
           }
       }
        return map.isEmpty();
    }
    public static int LongestSubstringWithoutRepeatingCharacters(String s) {
        //ababa
        int l = 0;
        int r = 0;
        int len = 0;
        HashSet<Character> set = new HashSet<>();
        while(r < s.length()){
            char c = s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            len = Math.max(len, (r-l+1));
            r++;
        }
//        for(int i = l; i<r;i++){
//            System.out.println(s.charAt(i));
//        }

        return len;
    }
    public static boolean isPalindrome(String s1){
        if(s1.length() == 0 ){
            return true;
        }
        int l = 0;
        int right = s1.length()-1;
        while(l <= right) {
            if (s1.charAt(l) == s1.charAt(right)) {
                l++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
