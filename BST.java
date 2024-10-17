import java.util.ArrayList;

public class BST {
    //https://youtu.be/qAeitQWjNNg?si=zz9WN63J-Bc9PGmY
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, int val){ //here return type is node becuz we want to recursively use this functipn , so we want to coonect next part to the same tree
        if(root == null){
            root = new Node(val);//if root is null so first value is inserted directly
            return root;
        }
        if(root.data > val){
            //insert in left subtree
          root.left =   insert(root.left , val);
                  //  ^posi  , ^value

        } else{
            root.right = insert(root.right,val);

        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" " );
        inorder(root.right);
    }

    public static boolean search(Node root, int key){        // time complexity = O(H) where h is height

        if(root == null){

            System.out.println("not found");
            return false;
        }
         if(root.data> key){
             //left subtree
             return search(root.left , key);
         }
         else if(root.data == key){
             System.out.println("found");
             return true;
         }
         else{
             return search(root.right , key);
         }
    }

    public static Node delete(Node root, int val){
        if(root.data > val){          //from here to...
            root.left = delete(root.left , val);
        }
        else if(root.data < val){
            root.right = delete(root.right , val);
        } //...here we are only searching for the data
        else{

            //here we find the data , and now actual deleting starts
            //case1
            if(root.left == null && root.right == null){ //means childless node
                return null;
                //directly link gets deleted and if java garbage collector does not find an use of the data . it drectly delteds the data
            }
            //case 2
            //only with one child , either left child is null or the right child is null
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3
            //inorder successor .... means left most node in our right subtree , becuz logically it is the next node in our sorted order.
            //first we make another function specailly for inorder successor ..
            Node IS = InorderSucc(root.right);
            root.data = IS.data; //replacing the data with inorderSucessor
            root.right =  delete(root.right , IS.data);  //get the remaining data in the form ofroot.rijght

        }

        return root;
    }
        public static Node InorderSucc(Node root){
        /*Here our root will be never be null becuz we are switiching to this method on after chyecking the condition
        so we dont take are of the special case here */
        while(root.left!=null){
            root = root.left;   //replacing the data i.e left most
        }
        return root;
        }

    public static void printinRange(Node root , int x, int y){
        if(root == null){
            return;
        }
        if(root.data >= x && root.data <=y){     //                 6
            printinRange(root.left , x, y);      //               /   \          (case1) supp range is (4,8)
            System.out.print(root.data + " "); //                4     8         (case2) supp range is (3,5)
            printinRange(root.right , x, y);     //             / \   / \        (case3) supp range is (7,9)
        }                                       //             3   5  7  9
        else if(root.data >= y){                //
            printinRange(root.left , x, y);
        }
        else{
            printinRange(root.right , x,y);
        }
    }

    public static void printRoot2Leaf(Node root , ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        //after reaching leaf
        if(root.left == null && root.right == null){
            printPath(path);
        }else {
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size()-1); //last removal
    }
        public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print( "-> " + path.get(i) );

        }
        System.out.println();
        }

    public static void main(String[] args) {
            int values[] = {8,5,3,1,4,6,10,11,14};
            Node root = null;
            for(int i=0;i<values.length;i++){
                root = insert(root, values[i]);
            }
            inorder(root);
            System.out.println();
            search(root, 1);
            delete(root , 10);
            System.out.print("after deleting we get " );
            inorder(root);
            System.out.println();
            printinRange(root, 4,11);
            System.out.println();
            ArrayList<Integer> path = new ArrayList<>();
            printRoot2Leaf(root,path);

    }
}
