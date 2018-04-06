package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/6.
 */
public class strGetIndex {
    //折半查找
    public int getIndex(String [] strs , String str)
    {
        if(strs==null||strs.length==0||str==null)
            return -1;
        int left = 0;
        int right = strs.length-1;
        int cur = -1;   //记录目标字符的位置
        int mid = 0;
        int i = 0;
        while (left<=right)
        {
            mid = (left+right)/2;
            if(strs[mid]!=null&&strs[mid].equals(str))
            {
                cur = mid ;
                right = mid -1;
            }
            else if(strs[mid]!=null)
            {
                if(strs[mid].compareTo(str)>0)
                {
                    right = mid-1;
                }else
                {
                    left = mid +1;
                }
            }else {
                i = mid ;
                while (strs[i]==null&&--i>=left)
                    ;
                if(i<left||strs[i].compareTo(str)<0)
                    left = mid+1;  //mid 到i 都是null，所以如果小于str，辣么，left就等于mid+1
                else {
                    cur = strs[i].equals(str)?i:cur;
                    right = i-1;
                }
            }
        }

        return cur;
    }
}