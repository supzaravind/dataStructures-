import java.util.*;

public class serializationLevel
{
    
   static  class Node
{
    int data;
    Node left;
    Node right;
    
    public Node()
    {}
    public Node(int val)
    {
        data=val;
        left=null;
        right=null;
    }

}
    public static void main(String args[])
    {
        System.out.println("Inside Main");
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(0);
        root.left.right=new Node(0);
        root.right.left=new Node(4);
        root.right.right=new Node(5);
        System.out.println("Tree Created");
        String s=serialize(root);
        System.out.println("After Serialization: "+ s);
    }
    Node root;
    public static String serialize(Node root)
    {
        StringBuilder sb=new StringBuilder();
        if(root==null)
        {
            sb.append("X,");
        }
        System.out.println("Root= "+root.data);
        //StringBuilder sb=new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty())
        {       
            Node firstelement=q.poll();

            sb.append(firstelement.data+",");
            if(firstelement.left!=null)
                {
                    //sb.append(","+firstelement.left.data);
                    q.add(firstelement.left);

                }
            if(firstelement.right!=null)
                {
                    //sb.append(","+firstelement.right.data);
                    q.add(firstelement.right);
                }


        }
        //System.out.println(sb);
        return sb.toString();


        }

    
}
