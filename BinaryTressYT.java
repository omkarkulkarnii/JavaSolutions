import java.util.LinkedList;
import java.util.Queue;
//https://youtu.be/-DzowlcaUmE?si=ucJ4wxM0dL5YkLHk
public class BinaryTressYT {      //parent class
    static class Node{
        int data; //data means root node
        Node left;
        Node right;
        Node(int data){
            //initial tree with only root
            this.data=data;
            this.left=null;
            this.right=null;
        }

    }
    static class BinaryTree{
        static int idx = -1; //indexing
        public static Node buildTree(int nodes[]){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }
        Node newNode = new Node(nodes[idx]); //new node for remaiinig data as we at first asssigned root
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);           //recurssion
            return newNode;
        }

    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data +" ");
    }

    public  static void levelorder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node currNode = q.remove()  ;
            if(currNode ==null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left !=null ){
                    q.add(currNode.left);

                }
                if(currNode.right !=null ){
                    q.add(currNode.right);

                }
                }
        }

    }

    public static int countOfNodes(Node root){
        //base case write at last;
        if(root == null){
            return 0;
        }
        int noOfleft = countOfNodes(root.left);
        int noOfright = countOfNodes(root.right);
        return noOfleft + noOfright + 1; //1 is of root node ie data node
    }

    public static int sumOfNodes(Node root){
        //base case write at last;
        if(root == null){
            return 0;
        }
        int SumOfleft = sumOfNodes(root.left);
        int SumOfright = sumOfNodes(root.right);
        return SumOfleft + SumOfright + root.data; //1 is of root node ie data node
    }

    public static int heightofTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightofTree(root.left);
        int rightHeight = heightofTree(root.right);
        int total = Math.max(leftHeight , rightHeight) + 1;
        return total;
    }

    public static int UnoptDiameter(Node root){
        if(root == null){
            return 0;
        }
        int leftd = UnoptDiameter(root.left);
        int rightd = UnoptDiameter(root.right);
        int totald = heightofTree(root.left) + heightofTree(root.right) + 1;
        return Math.max(leftd , Math.max(rightd,totald));
    }

    //We can optimise the diameter functio in O(n) form by collecting the information of each value in one node
    //meaning we do not have to run whole loop again for height recurssively , instead we can directly
    //on the get 2 types of values of each node in a new object form that we will create in a new class
    //it will be a variable to the new class type , So (height , diameter) will be
    //calulateed and stored in the same form each time


    //first we create a new class to create a variable of dedicated type
    static class Treeinfo{
        int ht;
        int diam;
        Treeinfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static Treeinfo optDiameter(Node root){
        //base case
        if(root == null){
            return new Treeinfo(0,0);
        }
        Treeinfo left = optDiameter(root.left);
        Treeinfo rght = optDiameter(root.right);
        int myHeight = Math.max(left.ht,rght.ht) +1;
        int diam1 = left.diam;
        int diam2 = rght.diam;
        int diam3 = left.ht + rght.ht + 1;
        int myDiam = Math.max(Math.max(diam1 , diam2) , diam3);
        Treeinfo myinfo = new Treeinfo(myHeight , myDiam);
        return myinfo;

    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        preorder(root); //O(n)
        System.out.println(" ");
        inorder(root); //O(n)
        System.out.println(" ");
        postorder(root);     //O(n)
        System.out.println(" ");
        levelorder(root); //O(n)
        System.out.println(" ");
        System.out.println("Total no of nodes = " + countOfNodes(root)); //O(n)
        System.out.println("Total sum of all nodes = " + sumOfNodes(root)); //O(n)
        System.out.println("Total height of tree is " + heightofTree(root)); //O(n)
        System.out.println("Total unoptimised diameter of tree is " + UnoptDiameter(root)); //O(n*n)
        System.out.println("Total optimised diameter of tree is " + optDiameter(root).diam); //O(n*n) , here we print diam becuase we dont want height
        System.out.println("Total optimised height of tree is " + optDiameter(root).ht); //O(n*n) , here we print ht becuase we dont want diam
    }

}
