import java.util.HashMap;
import java.util.LinkedList;

public class HashingImplementation {
    static class HashMap<K , V>{ //generics
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n;  //number of nodes
        private int N; //number of buckets
        private LinkedList<Node> buckets[]; //array of type LinkedList<Node>


    @SuppressWarnings("unchecked")   //removes warning from the code
    public HashMap(){    //constructor
        this.N = 4;
        this.buckets = new LinkedList[4];         //array initialization
        for(int i=0; i<4; i++){
            this.buckets[i] = new LinkedList<>();   //new linkedlist at evvery index of array
        }
    }
    private int hashFunction(K key){
        int i = key.hashCode();
        return  Math.abs(i) % N;   //% N so that we get value onlly between 0 to N-1 , it is the remainder
    }
    public void put(K key, V value){
        int bi = hashFunction(key); //speicfied up
       // int di = searchInLL(key, bi);

//        if(di == -1){  //key does not exist
//            buckets[bi].add(new Node(key , value));
//            n++; //node total count increment
//        }
//        else{
//            Node node = buckets[bi].get(di);
//            node.value = value;
//        }
//
//        double lambda = (double)n/N;
//        if(lambda > 2.0) {//in our example 2.0 is the thershold to increase the size of array , it can
//            //be k also which user can specify
//                //rehashing
//        }

    }

    }
}
