package InterviewDirectory.Recurrence_and_dynamicPlan;

/**
 * Created by huali on 2018/3/24.
 */
public class theLOngSubString {
    public String lcst2(String str1, String str2)
    {
        if(str1==null||str2==null||str1.length()==0||str2.length()==0)
            return "";
        char []chr1 = str1.toCharArray();
        char []chr2 = str2.toCharArray();
        int row = 0;
        int col = chr2.length-1;
        int max = 0;
        int end = 0;
        while (row<chr1.length)
        {
            int i = row;
            int j = col;
            int len = 0;
            while (i<chr1.length&&j<chr2.length)
            {
                if(chr1[i]!=chr2[j])
                {
                    len = 0;
                }else {
                    len++;
                }
                //记录最大值位置
                if(len>max)
                {
                    end = i;
                    max= len;
                }
                i++;
                j++;
            }
            if(col>0)
                col--;
            else
                row++;
        }
        return str1.substring(end-max+1,end+1);
    }
}