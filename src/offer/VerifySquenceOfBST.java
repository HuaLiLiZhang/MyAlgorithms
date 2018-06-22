package offer;

/**
 * Created by huali on 2018/6/21.
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST1(int [] sequence) {
        if(sequence==null||sequence.length<=0)
            return false;
        int length = sequence.length;

        return bst(sequence, 0, length-1);

    }
    public boolean bst(int[]sequence, int start, int end)
    {
        int i=0;
        int root = sequence[end];
        for(;i<end-1;i++)
        {
            if(sequence[i]>root)
                break;
        }
        int j=i;
        for(;j<end-1;j++)
        {
            if(sequence[j]<root)
                return false;
        }
        boolean left = true;
        if(i>0)
            left = bst(sequence, 0, i);
        boolean right = true;
        if(i<end-1)
            right = bst(sequence,i, end-i-1);
        return (left&&right);
    }
}