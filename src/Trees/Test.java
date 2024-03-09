package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Test {
    //PRE-ORDER TRAVERSAL
    static void preorder(Node root){
        if (root!=null){
            System.out.printf(root.key+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    //IN-ORDER TRAVERSAL
    static void inorder(Node root){
        if (root!=null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
    //  POST-ORDER TRAVERSAL
    static void postorder(Node root){
        if (root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.printf(root.key+" ");
        }
    }

    //BFS
    static void printLevelwise(Node root){
        if (root==null) return;
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()){
            Node curr=q.poll();
            System.out.print(curr.key+ " ");
            if (curr.left!=null)
                q.add(curr.left);
            if (curr.right!=null)
                q.add(curr.right);
        }
    }

    static void traversal(Node root){
        System.out.println("Preorder:");
        preorder(root);
        System.out.println();
        System.out.println("Inorder:");
        inorder(root);
        System.out.println();
        System.out.println("Postorder:");
        postorder(root);
        System.out.println();
        System.out.println("BFS:");
        printLevelwise(root);
        System.out.println();
    }


    //Iterative inorder traversal
    static void iteInorder(Node root){
        Stack<Node> st=new Stack<Node>();
        Node curr=root;
        while(curr!=null || !st.isEmpty()){
            while (curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            System.out.print(curr.key+" ");
            curr=curr.right;
        }
    }
    //Iterative Preorder traversal
    static void itePreorder(Node root){
        if (root==null) return;
        Stack<Node> st=new Stack<Node>();
        st.push(root);
        while (!st.isEmpty()){
            Node curr=st.pop();
            System.out.print(curr.key+" ");
            if (curr.right!=null){
                st.push(curr.right);
            }
            if (curr.left!=null){
                st.push(curr.left);
            }
        }
    }
    //Iterative Preorder traversal space optimized
    static void itePreorder2(Node root){
        if (root==null) return;
        Stack<Node> st=new Stack<Node>();
        Node curr=root;
        while (curr!=null || !st.isEmpty()){
            while (curr!=null){
                System.out.print(curr.key+" ");
                if (curr.right!=null){
                    st.push(curr.right);
                }
                curr=curr.left;
            }
            if (!st.isEmpty()){
                curr=st.pop();
            }
        }
    }

    //Iterative traversal
    static void iteTraversal(Node root){
        System.out.println("Inorder Iterative: ");
        iteInorder(root);
        System.out.println();
        System.out.println("Preorder Iterative: ");
        itePreorder2(root);
        System.out.println();
    }

    //Printing nodes at distance K
    static void printDistanceK(Node root, int k){
        if (root==null) return;
        if (k==0) System.out.print(root.key+" ");
        else {
            printDistanceK(root.left,k-1);
            printDistanceK(root.right,k-1);
        }
    }

    //Size of a binary tree
    static int getSize(Node root){
        if (root==null) return 0;
        else {
            return 1+getSize(root.left)+getSize(root.right);
        }
    }

    // Maximum in a Binary Tree
    static int getMax(Node root){
        if (root==null) return Integer.MIN_VALUE;
        else {
            return Math.max(root.key, Math.max(getMax(root.left),getMax(root.right)));
        }
    }

    //Number of leaf Nodes
    static int numLeaves(Node root){
        if (root==null) return 0;
        if (root.left==null && root.right==null) return 1;
        return numLeaves(root.left)+numLeaves(root.right);
    }

    //Diameter of a binary tree
    static int res=0;
    static int height(Node root){
        if (root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        res=Math.max(res,1+lh+rh);
        return 1+Math.max(lh,rh);
    }

    public static void main(String[] args) {
//        Node root=new Node(10);
//        root.left=new Node(20);
//        root.right=new Node(30);
//        root.left.left=new Node(40);
//        root.left.right=new Node(50);
        Node root = Input.treeInput(true, 0, true);
        if (root != null) {
            System.out.println("Binary Tree created successfully!");
        } else {
            System.out.println("Binary Tree is empty.");
        }

        //Tree traversals
        traversal(root);

        Scanner s=new Scanner(System.in);
        System.out.println("Enter the value of k: ");
        int k=s.nextInt();
        System.out.println("Printing nodes at distance "+k);
        printDistanceK(root,k);

        System.out.println();

        System.out.println("The size of this binary tree is: "+getSize(root));

        System.out.println("The greatest node in this tree is: "+getMax(root));

        System.out.println("The Number of leaf nodes are: "+numLeaves(root));

        iteTraversal(root);

        System.out.println("The diameter of this binary tree: "+height(root));

    }
}
