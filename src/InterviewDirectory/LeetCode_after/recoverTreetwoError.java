package InterviewDirectory.LeetCode_after;


import java.util.ArrayList;

/**
 * Created by huali on 2018/7/10.
 */
public class recoverTreetwoError {
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        TreeNode first=null ,second = null;
        for(int i=0;i<list.size()-1;i++)
        {
            if(list.get(i).val>list.get(i+1).val)
            {
                first = list.get(i);
                break;
            }
        }
        for(int i=list.size()-1;i>0;i--)
        {
            if(list.get(i).val<list.get(i-1).val)
            {
                second = list.get(i);
                break;
            }
        }
        TreeNode temp = new TreeNode(first.val);
        first.val = second.val;
        second.val = temp.val;
    }

    private void inorder(TreeNode root, ArrayList<TreeNode> list) {
        if(root==null)
            return ;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}