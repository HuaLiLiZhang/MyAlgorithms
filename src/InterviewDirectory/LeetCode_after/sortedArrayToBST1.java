package InterviewDirectory.LeetCode_after;

/**
 * Created by huali on 2018/7/9.
 */
public class sortedArrayToBST1 {
    public TreeNode sortedArrayToBST(int[] num) {
        return BST(num,0,num.length);
    }

    private TreeNode BST(int[] num, int start, int end) {
        if(start>=end)
            return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = BST(num,start, mid);
        root.right = BST(num, mid+1,end);
        return root;
    }
}