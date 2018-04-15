package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/15.
 */
public class KMPalgorithm {
    public int ViolentMatch(String str, String p)//暴力匹配
    {
        if(str==null||p==null||p.length()<1||str.length()<p.length())
            return -1;
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

    //失配时，模式串向右移动的位数为：已匹配字符数 - 失配字符的上一位字符所对应的最大长度值
    public int KMP(String str ,String p)
    {
        if(str==null||p==null||p.length()<1||str.length()<p.length())
            return -1;
        char [] chr = str.toCharArray();
        char [] mp = p.toCharArray();
        int i = 0;
        int k = 0;
        int [] next = getNextArray(mp);
        while (i<chr.length&&k<mp.length)
        {
            if(chr[i]==mp[k]) {
                ++i;
                ++k;
            }else if(next[k]==-1)
            // 代表模式串还是匹配的第一个，不相同，因为只有第一个的next为-1，所以i++
                    i++;
            else{
                k = next[k];
            }
        }
        return k==mp.length?i-k:-1;
    }

    public int[] getNextArray(char[] chs)
    {
        if(chs.length==1)
            return new int[]{-1};
        int []next = new int[chs.length];
        next[0] = -1;// 令第一个为-1，第二个为0；
        next[1] = 0;
        int pos = 2;
        int cn = 0;   //cn用来记住位置
        while (pos<next.length)
         {
            if(chs[pos-1] ==chs[cn])
            {
                next[pos++] = ++cn;
            }else if(cn>0)
            {
                cn = next [cn];
            }
            else {
                next[pos++] = 0;
            }
         }
         return next;
    }

}