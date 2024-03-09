package Trees;

import java.util.Scanner;

public class Input {
    public static Node treeInput(boolean isRoot, int parentdata, boolean isLeft){
        if (isRoot)
            System.out.println("Enter the root data: ");
        else {
            if (isLeft)
                System.out.println("Enter the left child of "+parentdata);
            else
                System.out.println("Enter the right child of "+parentdata);
        }
        Scanner s=new Scanner(System.in);
        int rootData=s.nextInt();
        if (rootData==-1) return null;
        Node root=new Node(rootData);
        Node leftChild=treeInput(false,rootData,true);
        Node rightChild=treeInput(false,rootData,false);
        root.left=leftChild;
        root.right=rightChild;
        return root;
    }
}
