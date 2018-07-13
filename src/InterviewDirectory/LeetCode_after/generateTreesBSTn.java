package InterviewDirectory.LeetCode_after;

import java.util.ArrayList;

/**
 * Created by huali on 2018/7/12.
 */
public class generateTreesBSTn {
    public ArrayList<TreeNode> generateTrees(int n) {
        return createTree(1,n);
    }

    private ArrayList<TreeNode> createTree(int low, int high) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if(low>high)
        {
            result.add(null);
            return result;
        }
        for(int i=low;i<=high;i++)
        {
        //    求根节点i的左右子树的集合
            ArrayList<TreeNode> left = createTree(low, i-1);
            ArrayList<TreeNode> right = createTree(i+1,high);
            for(int j=0;j<left.size();j++)
            {
                for(int k = 0;k<right.size();k++)
                {
                //    将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与左子树匹配
                    TreeNode newnode = new TreeNode(i);
                    newnode.left = left.get(j);
                    newnode.right = right.get(k);
                    result.add(newnode);
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        generateTreesBSTn g= new generateTreesBSTn();
        ArrayList<TreeNode> arr = g.generateTrees(3);
        for(int i=0;i<arr.size();i++)
        {
            TreeNode node = arr.get(i);
            while (node!=null)
            {
                preorder(node);
                System.out.println();
                break;
            }
        }
    }

    private static void preorder(TreeNode node) {
        if(node==null)
            return ;
        System.out.print(node.val);
        preorder(node.left);
        preorder(node.right);
    }
}