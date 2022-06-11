// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    
    public static int search(int[] A, int start, int end, int target) {
        for(int i = start; i <= end; i++) {
            if(A[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static Node build(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
            
        if(inStart > inEnd) {
            return null;
        }
        
        Node root = new Node(pre[preStart]);
        
        int rootIndex = search(in, inStart, inEnd, pre[preStart]);
        
        int leftTreeSize = rootIndex - inStart;
        int rightTreeSize = inEnd - rootIndex;
        
        root.left = build(pre, preStart + 1, preStart + leftTreeSize, in, inStart, rootIndex - 1);
        root.right = build(pre, preEnd - rightTreeSize + 1, preEnd, in, rootIndex + 1, inEnd);
        
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[], int n) {
        // code here 
        
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
