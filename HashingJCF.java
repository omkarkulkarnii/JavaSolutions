public class HashingJCF {

    public static void main(String[] args) {
        /*                   *************  HASHSET  **************
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);
        //search
        if(set.contains(1)){
            System.out.println("Set contains 1");
        }
        if(!set.contains(6)){
            System.out.println("Set does not contain 6");
        }

        set.remove(1);
        if(!set.contains(1)){
            System.out.println("Deleted");
        }

        System.out.println(set);

        //Iterator
        Iterator it = set.iterator();
        //hasnext and next function are used
        while(it.hasNext()){
            System.out.print(it.next() + " ");   //order is not specified

        }

                     *************** HASHSET END ******************* */



        /*                 ************** HASHMAPS ********************
    //for every pair ,we use hashmaps in java
        //   country, populat
    HashMap< String , Integer > map = new HashMap<>(); //key and value structure
    map.put("India" , 120); //insertion
    map.put("USA" , 30);
    map.put("China" , 150);
    System.out.println(map);   //unordered
    map.put("China" , 180);  //updates value
    System.out.println(map);

    //search
        System.out.println(map.containsKey("China"));
        System.out.println(map.get("India"));

        //for each loop
        // for(int val : set){ sout(val) }

        //iteration   -type              e :   colecti
        for(Map.Entry<String , Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " ");
            System.out.println(e.getValue() + " ");
        }




                              ******** END OF HASHMAPS ***********   */

    }

}
