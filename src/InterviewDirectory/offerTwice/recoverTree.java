package InterviewDirectory.offerTwice;


/**
 * Created by huali on 2018/7/25.
 */
public class recoverTree {
    public TreeNode Construct(int [] preorder, int [] inorder, int length)
    {
        if(preorder==null||inorder==null||length<=0)
            return null;
        return constructCore(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }

    private TreeNode constructCore(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend)
    {
         int value = preorder[pstart];
         TreeNode root = new TreeNode(value);
         root.left = root.right = null;
         if(pstart == pend)
         {
             if(istart == iend&&preorder[pstart]==inorder[istart])
             {
                 return root;
             }
             else
                 return null;
         }
         int[] rootInteger =  inorder;
         int i = 0;
         for(;i<rootInteger.length;i++)
         {
             if(rootInteger[i]==value)
                 break;
         }
         if(i==iend&&rootInteger[i]!=value)
             return null;
         int leftlength = i - istart;
         int leftPreOrderend = pstart+ leftlength;
         if(leftlength>0)
         {
             root.left = constructCore(preorder, pstart+1, leftPreOrderend, inorder, istart, i-1);
         }
         if(leftlength<pend - pstart)
         {
             root.right = constructCore(preorder, leftPreOrderend+1, pend, inorder,i+1, iend);
         }
         return root;
    }
    public static void main(String[] args)
    {
           int [ ] p = {1,2,4,7,3,5,6,8};
           int [] i = {4,7,2,1,5,3,8,6};
           recoverTree re = new recoverTree();
           TreeNode root = re.Construct(p,i,i.length);
           System.out.println(root.value);
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int v)
    {
        this.value = v;
    }
}