package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/15.
 */
public class KMPalgorithm {
    public int ViolentMatch(String str, String p)//暴力匹配
    {
        char [] chr = str.toCharArray();
        char [] mp = p.toCharArray();
        int i = 0;
        int k = 0;
        while (i<chr.length&&k<mp.length)
        {
            if(chr[i]==mp[k])
            {
                i++;  //①如果当前字符匹配成功（即S[i] == P[j]），则i++，j++
                k++;
            }else {
                i = i-(k-1);//②如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0
                k = 0;
            }
        }
        //匹配成功，返回模式串p在文本串s中的位置，否则返回-1
        if(k==mp.length)
            return i - k;
        else
            return -1;
    }

    
}