// PreOrder Tree Traversal using Iteration

import java.util.*;

public class PreorderIteration {
static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int d)
        {
            val=d;
            left=null;
            right=null;
        }
    }
    
public static  List<Integer> preorder(TreeNode root)
{
    List<Integer> result=new ArrayList<Integer>();
    Stack<TreeNode> nodeStack=new Stack<TreeNode>();
    nodeStack.push(root);
    while(!nodeStack.isEmpty())
    {
        TreeNode node=nodeStack.pop();

        if(node!=null)
        {
            result.add(node.val);
            nodeStack.push(node.right);
            nodeStack.push(node.left);
        }
    }
    return result;
}
public static void main(String args[])
{
    TreeNode root=new TreeNode(10);
    root.left=new TreeNode(7);
    root.right=new TreeNode(6);
    root.left.left=new TreeNode(5);
    root.right.left=new TreeNode(2);
    root.left.right=new TreeNode(8);
    root.right.right=new TreeNode(1);
    root.left.left.left=new TreeNode(3);
    root.right.left.right=new TreeNode(9);
    List<Integer> nodeList=preorder(root);
    System.out.println(nodeList.toString());



}

}