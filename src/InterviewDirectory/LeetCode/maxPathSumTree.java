package InterviewDirectory.LeetCode;


/**
 * Created by huali on 2018/7/7.
 */

//
// 解题思路：（转载自：<a href="http://blog.csdn.net/linhuanmars/article/details/22969069" target="_blank">http://blog.csdn.net/linhuanmars/article/details/22969069）
// * 这道题是求树的路径和的题目，不过和平常不同的是这里的路径不仅可以从根到某一个结点，
// * 而且路径可以从左子树某一个结点，然后到达右子树的结点，就像题目中所说的可以起始和终结于任何结点。
// * 在这里树没有被看成有向图，而是被当成无向图来寻找路径。
// * 因为这个路径的灵活性，我们需要对递归返回值进行一些调整，而不是通常的返回要求的结果。
// * 在这里，函数的返回值定义为以自己为根的一条从根到子结点的最长路径（这里路径就不是当成无向图了，
// * 必须往单方向走）。
// * 这个返回值是为了提供给它的父结点计算自身的最长路径用，
// * 而结点自身的最长路径（也就是可以从左到右那种）则只需计算然后更新即可。
// * 这样一来，一个结点自身的最长路径就是它的左子树返回值（如果大于0的话），
// * 加上右子树的返回值（如果大于0的话），再加上自己的值。
// * 而返回值则是自己的值加上左子树返回值，
// * 右子树返回值或者0（注意这里是“或者”，而不是“加上”，因为返回值只取一支的路径和）。
// * 在过程中求得当前最长路径时比较一下是不是目前最长的，如果是则更新。
// * 算法的本质还是一次树的遍历，所以复杂度是O(n)。而空间上仍然是栈大小O(logn)。
// */
// 
//// 因为maxPathSum不一定经过根节点，所以用maxValue整个遍历过程中出现过的最大值
public class maxPathSumTree {
    int max ;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        max = Integer.MIN_VALUE;
        addval(root);
        return max;

    }

    private int addval(TreeNode root) {
        if(root==null)
            return 0;
        //因为节点的值可以为负数，所以最大值取0和子树值的较大者
        int left = Math.max(0,addval(root.left));
        int right = Math.max(0, addval(root.right));
        //如果将当前root作为根节点，那么最大值是root.val+左子树最大值+右子树最大值
        max = Math.max(max, left+right+root.val);
        return Math.max(left,right)+root.val;
    }
    public static  void main(String[]args) {
        TreeNode head = new TreeNode(-2);
        TreeNode head1 = new TreeNode(-3);

        head.left = null;
        head.right = head1;
        head1.left=head1.right=null;
        maxPathSumTree max = new maxPathSumTree();
        System.out.println(max.maxPathSum(head));


    }
}