package InterviewDirectory.binaryTree_example;

/**
 * Created by huali on 2018/3/18.
 */
public class printTreeEdge1 {
    /**
     * 第一种规则；二叉树边界结点的逆时针打印。
     * 1.头结点为边界结点
     * 2.叶节点为边界结点
     * 3.如果结点在其所在的层中是最左和最右的，name也是边界结点。
     */
    public void printEdge(TreeNode head)
    {
        if(head == null)
            return ;
        int height = getHeight(head,0);  //得到tree的高度.
        TreeNode [][] edgeMap = new TreeNode[height][2];
        setEdgeMap(head,0,edgeMap);
        System.out.println();
        //for打印左边界
        for(int i=0;i!=edgeMap.length;i++)
        {
            System.out.print(edgeMap[i][0].val+" ");
        }
        //打印既不是左边界又不是右边界的叶子结点。
        printLeafNotInMap(head,0,edgeMap);
        //打印右边界，但不是左边界的结点。
        for(int i = edgeMap.length-1;i!=-1;--i)
        {
            if(edgeMap[i][0]!=edgeMap[i][1])
            {
                System.out.print(edgeMap[i][1].val+" ");
            }
        }
        System.out.println();
    }

    public int getHeight(TreeNode head , int l)
    {
        if(head==null)
            return l;
        return Math.max(getHeight(head.left,l+1),getHeight(head.right,l+1));
    }

    public void setEdgeMap(TreeNode head,int l,TreeNode [][]edgeMap)
    {
        if(head == null)
            return;
        edgeMap[l][0] = edgeMap[l][0]==null?head:edgeMap[l][0];
        System.out.print(edgeMap[l][0].val+",");
        edgeMap[l][1] = head;
        System.out.print(edgeMap[l][1].val+":");
        setEdgeMap(head.left,l+1,edgeMap);
        setEdgeMap(head.right,l+1,edgeMap);
    }
    public void printLeafNotInMap(TreeNode head, int l,TreeNode [][] m)
    {
        if(head==null)
            return ;
        if(head.left==null&&head.right==null&&head!=m[l][0]&&head!=m[l][1])
            System.out.print(head.val+" ");
        printLeafNotInMap(head.left,l+1,m);
        printLeafNotInMap(head.right,l+1,m);
    }


}