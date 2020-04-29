import java.io.*;
class Node
{
    int data;
    Node left,right;
    public Node(int val) 
    {
        data=val;
        left=null;
        right=null;
    }
}
public class findlevel
{
    public static int findLeftView(Node root,int key,int level)
    {
        if(root==null)
            return 0;
        if(root.data==key)
            return level;
        int downlevel=findLeftView(root.left,key,level+1);
        if(downlevel!=0)
            return downlevel;
        downlevel= findLeftView(root.right, key, level+1);
        return downlevel;

    }
    public static void main(String args[])throws IOException
    {
        Node root=new Node(3);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(1);
        root.left.right=new Node(4);
        int level=1;
        int key=3;
       int l= findLeftView(root,key,level);
       if(l==0)
        System.out.println("Element "+key+" Not Found!");
        else 
        System.out.println("Element " +key+ " found in Level "+l);        
    }
}