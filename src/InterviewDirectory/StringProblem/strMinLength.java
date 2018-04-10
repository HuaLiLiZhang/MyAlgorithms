package InterviewDirectory.StringProblem;

/**
 * Created by huali on 2018/4/10.
 */
public class strMinLength {
    public int minLength1(String str1,String str2)
    {
        if(str1==null||str2==null||str1.length()<str2.length())   //查找的str1串的长度要大于等于str2的长度
            return 0;
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int [] map = new int[256];  //
        for(int i =0;i!=ch2.length;i++)
        {
            map[ch2[i]]++;
        }
        int left = 0;
        int right = 0;
        int match = ch2.length;
        int minLen = Integer.MAX_VALUE;
        while (right!=ch1.length)
        {
            map[ch1[right]]--;
            if(map[ch1[right]]>=0)
            {
                match--;
            }
            if(match==0)
            {
                while (map[ch1[left]]<0)
                    map[ch1[left++]]++;
                minLen = Math.min(minLen, right-left+1);
                match++;
                map[ch1[left++]]++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE?0:minLen;
    }
}