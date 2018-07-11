package InterviewDirectory.LeetCode_after;

import java.util.ArrayList;

/**
 * Created by huali on 2018/7/11.
 */
public class isValidBSTBoolean {
    public boolean isValidBST(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        inorder(root, arr);
        for(int i=0;i<arr.size()-1;i++)
        {
            if(arr.get(i).val>=arr.get(i+1).val)
                return false;
        }
        return true;
    }

    private void inorder(TreeNode root, ArrayList<TreeNode> list) {
        if(root==null)
            return ;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}