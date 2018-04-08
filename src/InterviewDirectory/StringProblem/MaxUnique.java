package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/8.
 */
public class MaxUnique {
    //找到字符串中最长的无重复字符串子串。
    //时间复杂度、；O(N)，空间复杂度是O(N)。
    public int maxunique(String str)
    {
        if(str==null||str.length()==0)
            return -1;
        char[] ch1 = str.toCharArray();
        int [] map = new int [256];
        for(int i =0;i<256;i++)
            map[i]=-1;
        int len = 0;
        int pre = -1;
        int cur = 0;
        for(int i = 0;i<ch1.length;i++)
        {
            pre = Math.max(pre , map[ch1[i]]);
            cur = i - pre;
            len = Math.max(len , cur);
            map[ch1[i]] = i;
        }
        return len;
    }


}