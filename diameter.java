// Find the diameter of a tree// 
import java.io.*;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int val)
    {
        data=val;
        left=null;
        right=null;

    }

}
class diameterVal
{
    int diameter_ans= Integer.MIN_VALUE;
}

class diameter{

    public static int findHeight(Node root,diameterVal d)
    {
        if(root==null)
        return 0;
        int leftht= findHeight(root.left, d);
        int rightht=findHeight(root.right, d);
        d.diameter_ans=Math.max(d.diameter_ans,leftht+rightht+1);
        return 1+Math.max(leftht, rightht);


    }
    public static void findDiameter(Node root)
    {
        diameterVal d=new diameterVal();
        if( root==null)
            return;
        int height= findHeight(root,d);
        System.out.println("Diameter is : "+d.diameter_ans);
    }
    public static void main(String args[])throws IOException{
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3); 
        root.left.left=new Node(4);
        root.left.right=new Node(5); 
        
        findDiameter(root);
        
    }
}