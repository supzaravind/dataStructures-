import java.io.*;
import java.util.*;
import sun.launcher.resources.launcher;

public class BST
{
   public static List<Integer> order=new ArrayList<>();

    static Node root;
    static Node previous;
    BST()
    {
        root=null;
    }
static  class Node
{
Node leftchild;
Node rightchild;
Node parentNode;
int data;
public Node(int val)
{
    data=val;
    leftchild=rightchild=parentNode=null;
}

}

    public static void addNode(int key)
    {
        if(root==null)
        {
            root=new Node(key);
        }
        else
        {
            Node newNode= new Node(key);
            Node focusNode=root;
            Node parent;
            while(true)
            {
            parent=focusNode;
            if(key<focusNode.data)
                {
                    focusNode=focusNode.leftchild;
                    if(focusNode==null)
                    {
                        parent.leftchild=newNode;
                        parent.parentNode=parent;
                        return;
                    }
                }
                else
                {
                    if(key>focusNode.data)
                    {
                        focusNode=focusNode.rightchild;
                        if(focusNode==null)
                        {
                            parent.rightchild=newNode;
                            parent.parentNode=parent;
                            return;
                        }
                    }

                }
            }
        }


    }
    public static Node inOrder(Node node)
    {

        
        if(node!=null)
        {   //previous=node;
        
            inOrder(node.leftchild);
            System.out.println(node.data);
            order.add(node.data);
            inOrder(node.rightchild);
        }
        previous=node;
        return previous;
        
    
        
    }
    
    
    public static void  preOrder(Node node)

    {
        if(node!=null)
        {
            System.out.println(node.data);

            preOrder(node.leftchild);
            preOrder(node.rightchild);
        }


    }
    public static boolean isValidBST(Node root, int min,int max)
    {   
        
        if(root==null)
            return true;
        if(root.data<=min || root.data>max)
            return false;
        return (isValidBST(root.leftchild, min, root.data))&&isValidBST(root.rightchild,root.data,max);

    }
    public static void findKsmallest(int k)
    {
        int n=order.get(k);
        System.out.println("Kth smallest element: "+n);

    }
    public static void add(Node root,int key)
    {
        Node tempNode=root;
        Node parent;
        Node newNode=new Node(key);
    
        if(root==null)
        {
            root=newNode;
        }
        while(true)
        {
            parent=tempNode;
            if(key<tempNode.data)
            {
                tempNode=tempNode.leftchild;
                if(tempNode==null)
                {
                    parent.leftchild=newNode;
                    return;
                }
            }
            else
            {
                if(key>tempNode.data)
                {
                    tempNode=tempNode.rightchild;
                    if(tempNode==null)
                    {
                        parent.rightchild=newNode;
                        return;
                    }

                }
            }


        }

    }
    public static void main(String args[])
    {
        BST bst=new BST();
        int k=3;
        int minimum=Integer.MIN_VALUE;
        int maximum=Integer.MAX_VALUE;
        addNode(4);
        addNode(2);
        addNode(5);
        addNode(1);
        addNode(3);
        add(root,6);
        
        inOrder(root);
        System.out.println("Pre-Order Traversal");
        preOrder(root); 
        System.out.println("Is Binary Search Tree: "+isValidBST(root, minimum, maximum));
        findKsmallest(k);



    }

}