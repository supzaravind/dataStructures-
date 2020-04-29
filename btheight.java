import java.io.*;
import java.util.*;

class Node
{
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
public class btheight
{
    public static void height(Node root)
    {
        int qsize=0;
        int height=0;
        Node firstelement=null;
        if(root==null)
        return;
        Queue<Node> q= new ArrayDeque<>();
        q.add(root);
    while(!q.isEmpty())
    {
        qsize=q.size();
        while(qsize>0)
        {
            firstelement=q.poll();
            if(firstelement.left!=null)
            q.add(firstelement.left);
            if(firstelement.right!=null)
            q.add(firstelement.right);
        qsize--;
        }
        height++;

    }
    System.out.println("Height of the binary tree: "+height);
    }
    public static void print(Node root)
    {
    int  qsize=0;
    Node first_element=null;
    if(root==null)
    return;
    Queue<Node> q =new LinkedList<>();
    q.add(root);
    while(!q.isEmpty())
    {
        qsize=q.size();
        while(qsize>0)
        {
            first_element=q.peek();
            
            System.out.print(first_element.data + " ");
         q.remove();
            if(first_element.left!=null)
                q.add(first_element.left);
            if(first_element.right!=null)
                q.add(first_element.right);
            qsize--;
        }
        System.out.println();
    }

    
    }
    public static void main(String args[])throws IOException
    {
    Node root=new Node(1);
    root.left=new Node(2);
    root.right=new Node(3);
    root.left.left=new Node(4);
    root.left.right= new Node(5);
    root.right.left=new Node(8);
    root.right.right=new Node(9);
    height(root);
    print(root);

    }
}