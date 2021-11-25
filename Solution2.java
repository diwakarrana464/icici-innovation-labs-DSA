

import java.util.*;
import java.lang.*;
import java.io.*;

//structure of Node used in in binary search tree
class Node {
    int leftCount;						//number of nodes present in left subtree 
	int rightCount;						//number of nodes present in right subtree
    int val;									//value of node
	int height;							//height of the current node
    Node left;							//pointing to left child
    Node right;							//pointing to right child
    public Node(int val){
        this.val = val;
        this.leftCount = 0;
		this.rightCount = 0;
		this.height = 1;
        this.left = null;
        this.right = null;
    }
}

class Solution2
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//Driver code Here. One Arraylist having some data value
	   ArrayList<Integer> list = new ArrayList<>();
	   list.add(1);
	   list.add(2);
	   list.add(3);
	   list.add(4);
	   list.add(5);
	   list.add(6);
	   list.add(7);
	   list.add(8);
	   list.add(9);
	   Node root = buildBst(list);     // this method is used to build tree;
	   int dummy = updateLeftRightCount(root);  // fucntion to update left count and right count once insertion is over.
	   int n = search(root, 5);		  // FIRST PARAM: root of tree, SECOND PARAM: number BY which smaller element count is to found
	   System.out.println(n);
	  // printTree(root);
	}

	//1:Utility method to print preOrder traversel of tree
	public static void printTree(Node root){
	    if(root == null)
	    return;
	    System.out.print(root.val+" ");
	    printTree(root.left);
	    printTree(root.right);
	}

	//2::Method for height calculation
	public static	int height(Node N) {
			if (N == null)
				return 0;
 
        return N.height;
    }

	//3:: for finding maximum of two value;
	public static	int max(int a, int b) {
			return (a > b) ? a : b;
		}

	//4:: Utility function for right rotation
public static	Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }

	//5:: Utility function for left rotation
public static	Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }

//6:: Getting balance factor
public static	int getBalance(Node N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }

	//7:: inserting data into balanced binary searched tree
	public static Node insert(Node node, int key) {
 
        /* a.  Perform the normal BST insertion */
        if (node == null)
            return (new Node(key));
 
        if (key < node.val)
            node.left = insert(node.left, key);
        else if (key > node.val)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;
 
        /* b. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                              height(node.right));
 
        /* c. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.val)
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && key > node.right.val)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && key > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (balance < -1 && key < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
 

	//8: Method that returns number of element smaller than passed data as second argument
	// I choose iterative approach to avoid stack space, So more memory efficient
	public static int search(Node root, int data){
	    int smaller = 0;
	    if(root==null)
	    return smaller;
	    
	    while(true){

			if(root == null){
	            System.out.print("this data is not present but smaller than this data numbers are"+" ");
	            return smaller;
	        }

	        if(root.val < data){
	            smaller += (root.leftCount+1);
	            root = root.right;
	        }else if(root.val > data){
	            root = root.left;
	        }else{
	            smaller += root.leftCount;
	            break;
	        }
	    }
	    return smaller;
	}//end of searchSmaller

	//9: Method to build tree
	public static Node buildBst(ArrayList<Integer> list){
	    Node root = null;
	    for(int x : list){
	        root = insert(root, x);
	    }
	    return root;
	}//end of insert function

	//10:: function to update leftcount and rightcount
	public static int updateLeftRightCount(Node root){
			if(root == null)
				return 0;
			root.leftCount = updateLeftRightCount(root.left);
			root.rightCount = updateLeftRightCount(root.right);
			return root.leftCount + root.rightCount + 1;
	}
}//end of sullution2 class